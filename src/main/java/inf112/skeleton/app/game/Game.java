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

    }
}
