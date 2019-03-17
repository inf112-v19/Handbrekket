package inf112.skeleton.app.board;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.board.BoardElements;
import org.lwjgl.Sys;

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

	@Override
	public BoardElements checkSquare(int x, int y) {
		TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(0);
		TiledMapTileLayer.Cell cell = layer.getCell(x,y);
		String type = cell.getTile().getProperties().get("type").toString();

		BoardElements elementType = null;
		switch (type) {
			case "straightArrow":
				String dir = cell.getTile().getProperties().get("direction").toString();
				switch (dir) {
					case "north": elementType = BoardElements.CONVEYORBELT_MOVE_NORTH; break;
					case "south": elementType = BoardElements.CONVEYORBELT_MOVE_SOUTH; break;
					case "west": elementType = BoardElements.CONVEYORBELT_MOVE_WEST; break;
					case "east": elementType = BoardElements.CONVEYORBELT_MOVE_EAST; break;
				}
				break;
			case "rightArrow":
				dir = cell.getTile().getProperties().get("direction").toString();
				switch (dir) {
					case "north": elementType = BoardElements.CONVEYORBELT_TURN_RIGHT_MOVE_NORTH; break;
					case "south": elementType = BoardElements.CONVEYORBELT_TURN_RIGHT_MOVE_SOUTH; break;
					case "west": elementType = BoardElements.CONVEYORBELT_TURN_RIGHT_MOVE_WEST; break;
					case "east": elementType = BoardElements.CONVEYORBELT_TURN_RIGHT_MOVE_EAST; break;
				}
				break;
            case "leftArrow":
			    dir = cell.getTile().getProperties().get("direction").toString();
			    switch (dir) {
				    case "north": elementType = BoardElements.CONVEYORBELT_TURN_LEFT_MOVE_NORTH; break;
				    case "south": elementType = BoardElements.CONVEYORBELT_TURN_LEFT_MOVE_SOUTH; break;
				    case "west": elementType = BoardElements.CONVEYORBELT_TURN_LEFT_MOVE_WEST; break;
				    case "east": elementType = BoardElements.CONVEYORBELT_TURN_LEFT_MOVE_EAST; break;
			    }
			    break;
			case "hole": elementType = BoardElements.HOLES; break;
			case "wrench":
			    //TODO: change from int value to String name
                int value = (int) cell.getTile().getProperties().get("value");
                switch (value) {
                    case 0: elementType = BoardElements.WRENCH; break;
                    case -1: elementType = BoardElements.SPECIAL_WRENCH; break;
                    case 1: elementType = BoardElements.FLAG1; break;
                    case 2: elementType = BoardElements.FLAG2; break;
                    case 3: elementType = BoardElements.FLAG3; break;
                    case 4: elementType = BoardElements.FLAG4; break;
                }

		}
		return elementType;
	}
}



