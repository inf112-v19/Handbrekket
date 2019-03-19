package inf112.skeleton.app.board;

import java.util.ArrayList;

public class Board implements IBoard {
	private int width;
	private int height;
	private ArrayList<ArrayList<Square>> board;
	
	/**
	 * board constructor
	 * 
	 * @param x - width
	 * @param y	- height
	 */
	public Board(int x, int y) {
		width = x;
		height = y;
		board = new ArrayList<ArrayList<Square>>();
		/*
		 * Filling the board with Squares, x*y
		 */
		for(int i = 0; i < x; i++) {
			ArrayList<Square> line = new ArrayList<Square>();
			for(int j = 0; j < y; j++) {
				line.add(new Square(0,0));
			}
			board.add(line);
		}
	}

	public String printBoard () {

		String printout="";
		for (int i = 0; i < board.size(); i++) {
			printout="Column : "+i;

			for (int j = 0; j < board.get(i).size(); j++) {
				Square square = board.get(i).get(i);
				//printout+="\n"+square.printSquare();
			}
		}
		return printout;
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

	public Square getSquare(int x, int y) {
		
		return board.get(x).get(y);
	}



	@Override
<<<<<<< Updated upstream
	public void setSquare(int x, int y) {
		board.get(x).set(y, new Square(0,0));
=======
	public BoardElements checkSquare(int xCoordinate, int yCoordinate) {
		TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(0);
		TiledMapTileLayer.Cell cell = layer.getCell(xCoordinate,yCoordinate);
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
>>>>>>> Stashed changes
	}

}
