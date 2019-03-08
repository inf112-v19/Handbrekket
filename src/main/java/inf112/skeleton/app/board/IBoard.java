package inf112.skeleton.app.board;

import com.badlogic.gdx.maps.tiled.TiledMap;

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
     * Returns the map
     *

     * @return the map
     */
    TiledMap getMap();

}
