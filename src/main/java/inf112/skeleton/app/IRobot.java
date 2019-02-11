package inf112.skeleton.app;

/**
 * The most important piece in the game,
 * represents the robots and controls their abilities
 *
 * Should store its direction, HP and ID
 */
public interface IRobot {

    /**
     * Returns current hitpoints
     *
     * @return HP
     */
    int getHP();

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
    void move();

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
     * Returns the ID of the Robot
     *
     * @return ID
     */
    int getID();
}
