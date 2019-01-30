package inf112.skeleton.app;



public interface ISquare {
    /**
     *
     * @return Robot or NULL if empty
     */
    IRobot getRobot();

    /**
     *
     * @param dir
     * @return True if there is a wall, false otherwise.
     *
     */
    //todo: Implement the DIRECTION ENUM type & replace the int with DIRECTION
    boolean hasWall(int dir);

    /**
     *
     * @return True if there are any walls, false otherwise.
     */
    boolean hasWalls();


}
