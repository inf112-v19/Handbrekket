package inf112.skeleton.app.board;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.board.ConveyorBelts.IConveyorBelt;

import java.util.ArrayList;

public class Board implements IBoard {
	private int width;
	private int height;
	private TiledMap map;

	/**
	 * board constructor, with automatic width and height
	 *
	 * @param map - Map to create the board out of
	 */
	public Board(TiledMap map) {
		MapProperties properties = map.getProperties();
		this.width = properties.get("width", Integer.class);
		this.height = properties.get("height", Integer.class);
		this.map = map;
	}
	
	/**
	 * board constructor, manual width and height
	 *
	 * @param width - width
	 * @param height - height
	 * @param mapIn - Input map
	 */
	public Board(int width, int height, TiledMap mapIn) {
		this.width = width;
		this.height = height;
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

	public IConveyorBelt getConveyorBelt(int x, int y) {
		return null;
	}

	public void getLasers(int x, int y) {

	}

	@Override
	public BoardElements checkSquare(int x, int y) {
		TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(0);
		TiledMapTileLayer.Cell cell = layer.getCell(x,y);
		String type = cell.getTile().getProperties().get("type").toString();

		BoardElements elementType = null;
		switch (type) {
			case "conveyorBelt": elementType = BoardElements.CONVEYORBELT; break;
			case "hole": elementType = BoardElements.HOLE; break;
			case "wrench":
				String name = cell.getTile().getProperties().get("name").toString();
                	switch (name) {
                  		case "normal": elementType = BoardElements.WRENCH; break;
                   		case "hammer": elementType = BoardElements.SPECIAL_WRENCH; break;
                   		case "flag1": elementType = BoardElements.FLAG1; break;
                   		case "flag2": elementType = BoardElements.FLAG2; break;
                   		case "flag3": elementType = BoardElements.FLAG3; break;
                   		case "flag4": elementType = BoardElements.FLAG4; break;
                	}
				break;
			case "gear":
			    boolean rotationDirection = (boolean) cell.getTile().getProperties().get("rotationDirection");
			    if(rotationDirection)
			        elementType = BoardElements.GEAR_RIGHT;
			    else
			        elementType = BoardElements.GEAR_LEFT;
			    break;
            case "pusher":
                Direction dir = Direction.valueOf(cell.getTile().getProperties().get("direction").toString());
                boolean activatesOnEvenTurns = (boolean) cell.getTile().getProperties().get("activatesOnEvenTurns");
                if(activatesOnEvenTurns)
                    elementType = BoardElements.PUSHERS_EVEN.get(dir.getDirectionValue());
                else
                    elementType = BoardElements.PUSHERS_ODD.get(dir.getDirectionValue());
                break;
			case "startingPoint":
				String startPoint = "STARTING_POSITION_" + cell.getTile().getProperties().get("value").toString();
				elementType = BoardElements.valueOf(startPoint);
				break;
		}
		return elementType;
	}
}



