package inf112.skeleton.app;

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
