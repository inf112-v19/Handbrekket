package inf112.skeleton.app;

import java.util.ArrayList;

public class Board implements IBoard {
	private int width;
	private int height;
	private ArrayList<ArrayList<Square>> board;
	
	/**
	 * Board constructor
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

	public void printBoard () {

		for (int i = 0; i < board.size(); i++) {
			System.out.println("Column : " + i);

			for (int j = 0; j < board.get(i).size(); j++) {
				Square square = board.get(i).get(i);
				square.printSquare();
			}
		}
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
	public void setSquare(int x, int y) {
		board.get(x).set(y, new Square(0,0));
	}

}
