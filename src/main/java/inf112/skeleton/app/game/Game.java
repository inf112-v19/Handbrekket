package inf112.skeleton.app.game;

import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.board.IBoard;
import inf112.skeleton.app.board.ISquare;
import inf112.skeleton.app.card.*;
import inf112.skeleton.app.robot.IRobot;
import inf112.skeleton.app.robot.Robot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Game implements IGame {

    IRobot robot;
    Direction dir;
    ArrayList<ICard> programCards;


    public Game (IRobot robot, Direction dir ) {
        robot = new Robot(1,1,1);
        robot.setDir(dir);
        programCards = new ArrayList<ICard>();
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

    public void move(int x, int y) {
        robot.setXPosition(x);
        robot.setYPosition(y);
    }

    /**
     * Eirik
     * @param robot to be moved
     * @param card the movement card
     */


    public void move(IRobot robot, ICardMovement card) {
        //get current position of robot
        int currentPosX = robot.getXPosition();
        int currentPosY = robot.getYPosition();

        // retrieve moveValue
        int numberOfSteps = card.getMoveValue();

        //find which direction the robot is heading in
        Direction d = robot.getDir();
        String dir = d.getSymbol();
        if (dir.equals("N")) {
            currentPosY += numberOfSteps;
            int posY = currentPosY;
            robot.move(0, posY); //update vertical position
        } else if (dir.equals("S")) {
            currentPosY -= numberOfSteps;
            int posY = currentPosY;
            robot.move(0, posY); //update vertical position
        } else if (dir.equals("E")) {
            currentPosX += numberOfSteps;
            int posX = currentPosX;
            robot.move(posX, 0); //update horizontal position
        } else if (dir.equals("W")) {
            currentPosX -= numberOfSteps;
            int posX = currentPosX;
            robot.move(posX, 0); //update horizontal position
        }
    }






    /**
     * Eirik
     * @param robot to be moved
     * @param card the rotation card
     */
    public void move(IRobot robot, ICardRotation card) {
        boolean right = card.getRotationDirection();
        int value =  card.getRotationValue();

        Direction dir = robot.getDir();
        String d = dir.getSymbol();
        if (d.equals("N") && right){  //if the robot currently faces north and rotates to the right

            if (value == 1){ // turn 90 degrees to the right
                robot.setDir(Direction.EAST); //want to have dir = south
            }
            else if (value == 2){ //make a u-turn
                robot.setDir(Direction.SOUTH);
            }
        }
        else if (d.equals("N")) { //if the robot currently faces north and rotates to the left

            if (value == 1) { // turn 90 degrees to the left
                robot.setDir(Direction.WEST);
            }
            else if (value == 2){ //make a u-turn
                robot.setDir(Direction.SOUTH);
            }
        }
        else if (d.equals("E") && right){ //if robot faces east and rotates to the right

            if (value == 1){ // turn 90 degrees to the right
                robot.setDir(Direction.SOUTH);
            }
            else if (value == 2){ //make a u-turn
                robot.setDir(Direction.WEST);
            }
        }
        else if (d.equals("E")) { //if robot faces east and rotates to the left

            if (value == 1) { // turn 90 degrees to the left
                robot.setDir(Direction.NORTH);
            }
            else if (value == 2){ //make a u-turn
                robot.setDir(Direction.WEST);
            }
        }
        else if (d.equals("S") && right){ //if robot faces south and rotates to the right

            if (value == 1){ // turn 90 degrees to the right
                robot.setDir(Direction.WEST);
            }
            else if (value == 2){ //make a u-turn
                robot.setDir(Direction.NORTH);
            }
        }
        else if (d.equals("S")) { //of robot faces south and rotates to the left

            if (value == 1) { // turn 90 degrees to the left
                robot.setDir(Direction.EAST);
            }
            else if (value == 2){ //make a u-turn
                robot.setDir(Direction.NORTH);
            }
        }
        else if (d.equals("W") && right){ //if robot faces west and rotates to the right

            if (value == 1){ // turn 90 degrees to the right
                robot.setDir(Direction.NORTH);
            }
            else if (value == 2){ //make a u-turn
                robot.setDir(Direction.EAST);
            }
        }
        else if (d.equals("W")) { //if robot faces west and rotates to the left

            if (value == 1) { // turn 90 degrees to the left
                robot.setDir(Direction.SOUTH);
            }
            else if (value == 2){ //make a u-turn
                robot.setDir(Direction.EAST);
            }
        }
    }

    /**
     * Eirik
     */
    public void doPhase() {
        //TODO
        // Snu programkort
        //void turnProgramCard();
        //Flytte roboter utfra prioritet
        //void moveByPriority();
        // Bevege samlebånd
        //
        //Bevege tannhjul
        //Aktivere laser
        //Telle opp skade

        //Flytte backup
        //Registrere flagg
    }

    @Override
    public void doRound() {

    }

    /**
     * Eirik

    public void doRound() /**{
        //cardLocked(); // Program card must be locked
        for (int i = 0; i < 4; i++){
            doPhase(); //1 round = 4 phases
        }
    }
    */

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

    }

    /**
     * Marius
     * @param robot to update the backup of
     */
    public void updateBackUp(IRobot robot) {

    }

    /**
     * Alba
     */
    public void dealCards() {

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

    }/**
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
}
