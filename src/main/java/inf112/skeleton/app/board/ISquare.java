package inf112.skeleton.app.board;

import inf112.skeleton.app.robot.Robot;

/**
 * Represents a square on the board,
 * should be able to store special squares, walls and robots
 *
 * Todo:implement special squares
 */
public interface ISquare {
    /**
     * Returns the robot currently in the Square
     *
     * @return robot or NULL if empty
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
     * Puts robot in Square
     */
    //TODO: change robot to IRobot
    boolean putRobotInSquare(Robot robot);


}
