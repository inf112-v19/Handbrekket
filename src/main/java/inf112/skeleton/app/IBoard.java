package inf112.skeleton.app;

/**
 * The main structure that contains the game board.
 * As of right now it should only keep a list of the game squares,
 * be able to access those squares and return height and width
 *
 * The height and width should be final after construction (at least for now)
 */
public interface IBoard {
    /**
     * Returns the height of the board
     * @return height
     */
    int getHeight();

    /**
     * Returns the width of the board
     * @return width
     */

    int getWidth();

    /**
     * Returns the Square in the given coordinates
     *
     * @param x the x coordinate on the board
     * @param y the y coordinate on the board
     * @return the Square
     */
    ISquare getSquare(int x, int y);
}
