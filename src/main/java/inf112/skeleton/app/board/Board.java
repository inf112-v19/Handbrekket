package inf112.skeleton.app.board;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.ArrayList;

public class Board implements IBoard {
	private int width;
	private int height;
	private TiledMap map;

	/**
	 * Board constructor, derives everything it needs from the map
	 *
	 * @param map the map to use as base
	 */

	public Board(TiledMap map) {
		MapProperties properties = map.getProperties();
		this.width = properties.get("width", Integer.class);
		this.height = properties.get("height", Integer.class);
		this.map = map;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	//Might need to change this depending on whether it works or not
	//TODO: implement this
	@Override
	public ArrayList<BoardElements> getWall(int x, int y) {
		TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(1);
		TiledMapTileLayer.Cell cell = layer.getCell(x, y);

		return null;
	}

	@Override
	public TiledMap getMap() {
		return map;

	}

	@Override
	public BoardElements checkSquare(int x, int y) {
		TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(0);
		TiledMapTileLayer.Cell cell = layer.getCell(x, y);
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
