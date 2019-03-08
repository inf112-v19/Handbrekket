package inf112.skeleton.app.game;

import inf112.skeleton.app.board.IBoard;
import inf112.skeleton.app.board.ISquare;
import inf112.skeleton.app.card.ICardMovement;
import inf112.skeleton.app.card.ICardRotation;
import inf112.skeleton.app.robot.IRobot;

import java.util.ArrayList;

public class Game implements IGame {

    /**
     * Gets board
     * Marius
     * @return
     */
    public IBoard getBoard() {
        //TODO:
        return null;
    }

    /**
     * Eirik
     * @param x the new x-coordinate
     * @param y the new y-coordinate
     */
    public void move(int x, int y) {

    }

    /**
     * Eirik
     * @param robot to be moved
     * @param card the movement card
     */
    public void move(IRobot robot, ICardMovement card) {

    }

    /**
     * Eirik
     * @param robot to be moved
     * @param card the rotation card
     */
    public void move(IRobot robot, ICardRotation card) {

    }

    /**
     * Eirik
     */
    public void doPhase() {

    }

    /**
     * Eirik
     */
    public void doRound() {

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
