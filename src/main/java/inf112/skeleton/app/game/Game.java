package inf112.skeleton.app.game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.board.*;
import inf112.skeleton.app.card.*;
import inf112.skeleton.app.robot.*;
import org.lwjgl.Sys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Game implements IGame {
    private ArrayList<ICard> programCards = new ArrayList<>();
    private ArrayList<int[]> boardHoles = new ArrayList<>();
    private ArrayList<IMovementBoardElement> conveyorBelts = new ArrayList<>();
    private ArrayList<IMovementBoardElement> expressConveyorBelts = new ArrayList<>();
    private ArrayList<IProgramRegister> allProgramRegisters = new ArrayList<>();
    private IProgramRegister currentRegister;
    private Board board;

    //TODO: consider making numberOfPlayers a private variable in Game
    public Game(TiledMap tiledMap, int numberOfPlayers) {
        board = new Board(tiledMap);
        createDeck();
        shuffleDeck();
        programRegistersFactory(numberOfPlayers);
        currentRegister = allProgramRegisters.get(0);
    }

    private void programRegistersFactory (int numberOfPlayers) {
        for(int i = 0; i < numberOfPlayers; i++){
            //TODO: get starting position from the board.
            int[] robotPos = {i+5,5};
            Robot robot = new Robot(i+1, robotPos);
            ProgramRegister programRegister = new ProgramRegister(robot);
            allProgramRegisters.add(programRegister);
        }
    }

    /**
     * Gets board
     * Marius
     * @return
     */
    public IBoard getBoard() {
        return board;
    }

    public IProgramRegister getCurrentRegister() {
        return currentRegister;
    }

    /**
     *
     * @param coordinates
     */
    @Override
    public void absoluteMove(IRobot robot, int[] coordinates){
        robot.setPosition(coordinates);
    }

    /**
     * Eirik
     * @param robot to be moved
     * @param card the movement card
     */
    public void relativeMove(IRobot robot, ICardMovement card) {
        //get current position of robot
        int[] coordinates = robot.getPosition();

        // retrieve moveValue
        int numberOfSteps = card.getMoveValue();

        coordinates[0] += robot.getDir().getDeltaX() * numberOfSteps;
        coordinates[1] += robot.getDir().getDeltaY() * numberOfSteps;

        robot.setPosition(coordinates);
    }

    /**
     * Turns the current Robot
     *
     * @param card the rotation card
     */
    @Override
    public void rotationMove(IRobot robot, ICardRotation card) {
        for(int i = 0; i < card.getRotationValue(); i++)
            currentRegister.getRobot().rotate(card.getRotationDirection());
    }

    /**
     * Checks if the robot from the currentRegister is on any of the holes in the board
     * TODO: needs to be tested
     * @return true if on any holes, false otherwise
     */
    public boolean checkIfOnHoleOrOutsideBoard(IRobot robot){
        int[] robotPos = robot.getPosition();

        //Checks if the robot's position overlaps with any holes
        for(int[] holePos : boardHoles){
            if(Arrays.equals(holePos, robotPos))
                return true;
        }

        //Checks if the robot is outside of the board
        if(robotPos[0] > board.getWidth() || robotPos[0] < 0)
            return true;
        if(robotPos[1] > board.getHeight() || robotPos[1] < 0)
            return true;

        return false;
    }

    //TODO: needs to be expanded with conveyorbelts & similar, also more comments
    private void initializeBoardElements() {
        int width = board.getWidth();
        int height = board.getHeight();

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                BoardElements elem = board.checkSquare(i,j);
                int[] tempCoordinates = {i,j}; //Temporarily creates coordinates for the elements that need those
                if(elem == BoardElements.HOLES) {
                    boardHoles.add(tempCoordinates);
                } else if (BoardElements.CONVEYORBELTS.contains(elem)) {
                    Direction dir = elem.getDirection();
                    Boolean turnDirection;
                    if(BoardElements.CONVEYORBELTS_TURN_LEFT.contains(elem)) {
                        turnDirection = false;
                    } else if(BoardElements.CONVEYORBELTS_TURN_RIGHT.contains(elem)) {
                        turnDirection = true;
                    } else
                        turnDirection = null;

                    IMovementBoardElement movementBoardElement = new MovementBoardElement(tempCoordinates, dir, 1, turnDirection);
                    conveyorBelts.add(movementBoardElement);
                }
            }
        }
    }

    //TODO: consider renaming methods
    private void doMoveAccordingToCardType(IRobot robot, ICard inputCard) {
        if(inputCard.getType() == 1) { //Movement Cards
            relativeMove(robot, (ICardMovement) inputCard);
        } else if (inputCard.getType() == 2) { // Rotation Cards
            rotationMove(robot, (ICardRotation) inputCard);
        }
    }

    /**
     * Eirik
     */
    @Override
    public void doPhase(int phaseNumber) {
        /**
         * Phase order:
         * 1: Reveal Program Cards
         * 2: Move robots according to priority
         * 3: Board Elements Move
         * TODO 4: Lasers Fire
         * TODO 5: Touch checkpoints
         */

        //Flips a card in each of the registers
        for(IProgramRegister register : allProgramRegisters) {
            register.turnACard(phaseNumber);
        }

        //Makes a new list of all of the registers then in turn does the move of the highest priority then removes that register from the list
        //TODO: needs to be tested, not sure if it works as intended to be honest
        ArrayList<IProgramRegister> programRegistersToSort = new ArrayList<>(allProgramRegisters);
        for(int i = 0; i < allProgramRegisters.size(); i++) {
            int highestPriorityIndex = 0;
            for(int j = 1; j < programRegistersToSort.size(); j++) {
                int highestPrioritySoFar = programRegistersToSort.get(highestPriorityIndex).getActiveCardInPosition(phaseNumber).getPriority();
                int newPriority = programRegistersToSort.get(j).getActiveCardInPosition(phaseNumber).getPriority();
                if(newPriority > highestPrioritySoFar)
                    highestPriorityIndex = j;
            }
            IProgramRegister currentHighestPriority = programRegistersToSort.get(highestPriorityIndex);
            doMoveAccordingToCardType(currentHighestPriority.getRobot(), currentHighestPriority.getActiveCardInPosition(phaseNumber));

            checkIfOnHoleOrOutsideBoard(currentHighestPriority.getRobot());

            programRegistersToSort.remove(currentHighestPriority);
        }

        //TODO: should be expanded to have all boardElements
        activateConveyorBelts();
        //fireLasers(); not implemented yet

        //Game game = new Game()
        //TODO
        // Snu programkort
        //void turnProgramCard();
        //Flytte roboter utfra prioritet
        //void moveByPriority();
        // Bevege samlebånd
        //game.activateConveyorBelt();

        //Bevege tannhjul
        //Aktivere laser
        //game.activateLaser();
        //Telle opp skade
        //(if() HP++)
        //Flytte backup
        //Registrere flagg
    }

    @Override
    public void doRound() {

        /**
         * Eirik
         public void doRound() /**{
         //cardLocked(); // Program card must be locked
         for (int i = 0; i < 4; i++){
         doPhase(); //1 round = 4 phases
         }
         }
         */
    }

    /**
     * Marius
     * @return
     */
    public ArrayList<Event> makeEventList() {
        return null;
    }
    //TODO:
    //Roboter beveger seg.
    //MAP...
    //liste over eventer i fasen
    /**
     * Marius
     * @param listOfEvents
     */
    public Event readEvents(ArrayList<Event> listOfEvents) {
        //TODO:
        //
        return null;

    }

    /**
     * Eirik
     * @param robot to be repaired
     */
    public void repair(IRobot robot) {
        robot.changeHP(-1);
    }

    /**
     * Mari
     * @param robot to update the backup of
     */
    public void updateBackUp(IRobot robot) {
        int[]backUp = new int[2];
        backUp = robot.getPosition();
        robot.setBackup(backUp);
    }

    //TODO: change to deal to ALL registers, not just the current one.
    @Override
    public void dealCards() {
        final int numberOfCardsToDeal = GameRuleConstants.MAX_CARDS_IN_REGISTER.getValue();
        ArrayList<ICard> temp = new ArrayList<>(programCards.subList(0,numberOfCardsToDeal));
        currentRegister.setAvailableCards(temp);
    }

    @Override
    public void activateFlag() {

    }

    /**
     * Marius
     * @param width the width of the board
     * @param height the height of the board
     * @param board the board given 2D integer array
     */
    public void createBoard(int width, int height, int[][] board) {

    }

    /**
     * Marius
     * @param robot
     */
    public void checkLeaveBoard(IRobot robot) {

    }

    /**
     * Alba
     * @param robot
     */
    public void restoreRobot(IRobot robot) {

    }

    /**
     * Alba
     * @param cards
     */
    public void removeCard(boolean[] cards) {

    }

    /**
     * Creates a deck of programCards of all of the "simple" types, stored in the ArrayList programCards
     * As of right now it's hard-coded, but in the future we should probably make it more dynamic
     */
    private void createDeck() {
        //Creates the cards "Backup", "Move 1", "Move 2", "Move 3"
        createMovementCards(6,10,430,-1);
        createMovementCards(18,10,490,1);
        createMovementCards(12,10,670,2);
        createMovementCards(6, 10,790,3);

        //Creates the cards "U-Turn", "Rotate Right", "Rotate Left"
        createRotationCards(6,  10,10,true, 2);
        createRotationCards(18, 20,80,true, 1);
        createRotationCards(18, 20,70,false,1);
    }

    /**
     * Creates a set of movement cards based on the input given
     * @param cardNum The number of cards to create
     * @param interval The interval between each card's priority
     * @param intervalStart The starting value of the priority
     * @param moveValue The amount of movement of the card
     */
    private void createMovementCards(int cardNum, int interval, int intervalStart, int moveValue) {
        for(int i = 0; i < cardNum; i++){
            programCards.add(new MovementCard(intervalStart + i * interval,moveValue));
        }
    }

    /**
     * Creates a set of rotation cards based on the input given
     * @param cardNum The number of cards to create
     * @param interval The interval between each card's priority
     * @param intervalStart The starting value of the priority
     * @param rotationDirection The direction of the rotation (TRUE = right, FALE = left)
     * @param rotationValue The amount of rotation to be performed
     */
    private void createRotationCards(int cardNum, int interval, int intervalStart, boolean rotationDirection, int rotationValue) {
        for(int i = 0; i < cardNum; i++){
            programCards.add(new RotationCard(intervalStart + i * interval, rotationDirection, rotationValue));

        }
    }

    /**
     * Shuffles the deck of programCards
     */
    private void shuffleDeck() {
        Collections.shuffle(programCards);
    }

    //TODO: should probably have guards
    @Override
    public void addCardToDeck(ICard card) {
        programCards.add(card);
    }

    @Override
    public boolean checkIfContainsRobot(int xCoordinate, int yCoordinate) {
        return false;
    }

    @Override
    public void activateConveyorBelts() {
        //Because of how the rules handles conflicts with movement a "prediction" of how where the robots will end up is needed
        ArrayList<int[]> predictedCoordinates = new ArrayList<>();

        for(int i = 0; i < allProgramRegisters.size(); i++) {
            //Gets the coordinates of each robot and compares them to the coordinates of the conveyor belts
            int[] currentRobotCoordinates = allProgramRegisters.get(i).getRobot().getPosition();
            for(IMovementBoardElement conveyorBelt : conveyorBelts) {
                if(Arrays.equals(currentRobotCoordinates,conveyorBelt.getCoordinates())) {
                    currentRobotCoordinates[0] += conveyorBelt.getDirection().getDeltaX();
                    currentRobotCoordinates[1] += conveyorBelt.getDirection().getDeltaY();
                }
            }
            predictedCoordinates.add(currentRobotCoordinates);
        }

        //TODO: finish section that checks if movement is legal by processing the predictedCoordinates list

        for(int i = 0; i < allProgramRegisters.size(); i++) {
            //TODO: change this, it shouldn't use absolute movement
            absoluteMove(allProgramRegisters.get(i).getRobot(), predictedCoordinates.get(i));
        }
    }

    //TODO: complete
    @Override
    public boolean canMove(int[] startCoordinates, int[] destinationCoordinates) {
        //Checks to see if the positions are adjacent
        int deltaX = destinationCoordinates[0] - startCoordinates[0];
        int deltaY = destinationCoordinates[1] - startCoordinates[1];
        if(deltaX > 1 || deltaX < -1 || deltaY > 1 || deltaY < -1)
            throw new IllegalArgumentException("The positions are not adjacent");



        return true;
    }
}