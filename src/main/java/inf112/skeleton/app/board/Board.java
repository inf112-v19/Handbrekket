package inf112.skeleton.app.board;

import com.badlogic.gdx.maps.tiled.TiledMap;

import java.util.ArrayList;

public class Board implements IBoard {
	private int width;
	private int height;
	private TiledMap map;

	/**
	 * board constructor
	 *
	 * @param x - width
	 * @param y - height
	 */
	public Board(int x, int y, TiledMap mapIn) {
		width = x;
		height = y;
		map = mapIn;
	}
	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public TiledMap getMap() {
		return map;
	}

		/*
	public BoardElements checkSquare() {

	}
	*/
}



