package inf112.skeleton.app.robot;

import inf112.skeleton.app.board.Direction;

/**
 * The most important piece in the game,
 * represents the robots and controls their abilities
 *
 * Should store its direction, HP and ID
 */
public interface IRobot {

    /**
     * Returns current lives
     *
     * @return Lives
     */
    int getLives();

    /**
     * Decrease lives by one
     *
     */
    void decreaseLives();

    /**
     * Returns current hitpoints
     *
     * @return HP
     */
    int getHP();

    /**
     * powerDowns a robot
     *
     */
    void powerDown();

    /**
     * check if robot is powerDown
     */
    boolean isPoweredDown();

    /**
     * Returns the current direction the robot is facing
     *
     * @return direction
     */
    Direction getDir();

    /**
     * Changes the current direction
     *
     * @param dir, the new direction to face
     */
    void setDir(Direction dir);

    /**
     * Attempts to move forward,
     * Should throw some kind of exception if not possible
     * NON-ESSENTIAL ATM
     */
    void move(int xCoordinate, int yCoordinate);

    /**
     *
     * @param HP the new HP
     * @return new HP
     */
    int setHP(int HP);

    /**
     * Changes the HP,
     * Positive to add health
     * Negative to remove health
     *
     * @param HP the HP to be added/removed
     * @return new HP
     */
    int changeHP(int HP);

    /**
     * Returns the ID of the robot
     *
     * @return ID
     */
    int getID();

    /**
     * returns an array of the backup
     * with coordinate x on pos 0, and coordinate y on pos 1
     *
     * @return position
     */
    int[] getBackup();


    /**
     * sets the state of the backup
     * with the coordinate x on pos 0, and coordinate y on pos 1
     *
     * @param backup
     */
    void setBackup(int[] backup);

    /**
     * returns the position of the robot in the x-coordinate
     *
     * @return the x-position of the robot
     */
    int getXPosition();

    /**
     * Sets the x-position of the robot
     *
     * @param x-coordinate of current position
     */
    void setXPosition(int xCoordinate);



    /**
     * returns the position of the robot in the x-coordinate
     *
     * @return the y-position of the robot
     */
    int getYPosition();

    /**
     * Sets the y-position of the robot
     *
     * @param y-coordinate of current position
     */
    void setYPosition(int yCoordinate);

}
