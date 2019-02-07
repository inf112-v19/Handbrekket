package inf112.skeleton.app;

/**
 * Represents a square on the board,
 * should be able to store special squares, walls and robots
 *
 * Todo:implement special squares
 */
public interface ISquare {
    /**
     * Returns the Robot currently in the Square
     *
     * @return Robot or NULL if empty
     */
    boolean doesTheSquareContainARobot();

    /**
     * Checks if there is a wall in the given direction
     *
     * @param dir The direction to check
     * @return True if there is a wall, false otherwise.
     *
     */
    boolean hasSquareWall(Direction dir);

    /**
     * Checks if the Square has any walls
     *
     * @return True if there are any walls, false otherwise.
     */
    boolean hasSquareWalls();

    /**
     * Puts Robot in Square
     */
    //TODO: change Robot to IRobot
    boolean putRobotInSquare(Robot robot);

    /**
     * Prints the square
     */
    void printSquare ();

}
