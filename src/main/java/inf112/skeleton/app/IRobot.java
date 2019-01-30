package inf112.skeleton.app;

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
    //todo: add DIRECTION as return type once that's ready
    void getDir();

    /**
     * Changes the current direction
     *
     * @param dir, the new direction to face
     */
    //todo: replace int with DIRECTION
    void setDir(int dir);

    /**
     * Attempts to move forward,
     * NON-ESSENTIAL ATM
     */
    void move();

    /**
     * Changes the HP,
     * Positive to add health
     * Negative to remove health
     *
     * @param HP
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
