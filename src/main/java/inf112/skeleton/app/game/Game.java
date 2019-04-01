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
    private ArrayList<IMovementBoardElements> conveyorBelts = new ArrayList<>();
    private ArrayList<IMovementBoardElements> expressConveyorBelts = new ArrayList<>();
    private ArrayList<IProgramRegisters> allProgramRegisters = new ArrayList<>();
    private IProgramRegisters currentRegister;
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
            ProgramRegisters programRegister = new ProgramRegisters(robot);
            allProgramRegisters.add(programRegister);
        }
    }

    //Todo: Used for testing, should be removed before next hand-in
    public ArrayList<ICard> getCards() {
        ArrayList<ICard> temp = new ArrayList<>();
        temp.addAll(programCards.subList(0,9));
        return temp;
    }

    public Game (int numberOfPlayers) {
        programCards = new ArrayList<ICard>();
    }

    private void ProgramRegistersFactory (int numberOfPlayers) {
        for(int i = 0 ; i<numberOfPlayers; i++){
             IRobot robot = new Robot(1,1+i,1+i);
        }
    }
    /**
     * Gets board
     * Marius
     * @return
     */
    public IBoard getBoard() {
        //TODO:
        return null;
    }

    @Override
    public void absoluteMove(IRobot robot, int[] coordinates){
        robot.setPosition(coordinates);
    }

    /**
     * Eirik
     * @param robot to be moved
     * @param card the movement card
     */
    @Override
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
     * Eirik
     * @param robot to be moved
     * @param card the rotation card
     */
    @Override
    public void rotationMove(IRobot robot, ICardRotation card) {
        for(int i = 0; i < card.getRotationValue(); i++)
            currentRegister.getRobot().rotate(card.getRotationDirection());
    }

    /**
     * Eirik
     */
    public void doPhase() {
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
        backUp[0] = robot.getXPosition();
        backUp[1] = robot.getYPosition();
        robot.setBackup(backUp);
    }

    /**
     * Alba
     */
    public void dealCards() {
        int howManyNewCards = 9 - programRegister.getRobot().getHP();
        //int howManyNewCards = 9- currentRegister.getRobot().getHP();
        ArrayList<ICard> newCards = new ArrayList<>(howManyNewCards);
        for(int i = 0; i < howManyNewCards; i++){
            newCards.set(i, programCards.get(i));
            programCards.remove(i);
        }

    }

    /**
     * Alba
     * @param square
     */
    public void activateFlag(ISquare square) {

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
     * add used card to stack
     *
     * @param card
     */
    @Override
    public void putCardToStack(ICard card) {
        programCards.add(card);
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


    @Override
    public boolean checkIfContainsRobot(int[] coordinate) {
        return false;
    }

    public void activateConveyorBelts() {
    }
}
