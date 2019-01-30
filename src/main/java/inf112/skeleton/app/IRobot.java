package inf112.skeleton.app;

public interface IRobot {

    /**
     * Returns current hitpoints
     *
     * @return int
     */

    int getHP();

    /**
     * Returns the current direction
     *
     * @return DIRECTION
     */
    //todo: add DIRECTION as return type once that's ready
    void getDir();

    /**
     * Changes the current direciton
     *
     * @param dir
     */
    //todo: replace int with DIRECTION
    void setDir(int dir);

    void move();

    int changeHP(int HP);

    int getID(int ID);

}
