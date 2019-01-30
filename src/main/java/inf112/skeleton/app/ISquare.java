package inf112.skeleton.app;

public interface ISquare {
    /**
     * Returns the Robot currently in the Square
     *
     * @return Robot or NULL if empty
     */
    IRobot getRobot();

    /**
     * Checks if there is a wall in the given direction
     *
     * @param dir The direction to check
     * @return True if there is a wall, false otherwise.
     *
     */
    //todo: Implement the DIRECTION ENUM type & replace the int with DIRECTION
    boolean hasWall(int dir);

    /**
     * Checks if the Square has any walls
     *
     * @return True if there are any walls, false otherwise.
     */
    boolean hasWalls();
}
