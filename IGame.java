package inf112.skeleton.app;

/** 
 * The interface contains the logic for the whole game.
 * Game will implement board as field.
 */
public interface IGame {

	/**
	 * Retrieves the board from IBoard
	 * @return board from IBoard
	 */
	IBoard getBoard();
	
	
	/**
	 * Absolute movement (robot) 
	 * @param x the new x-coordinate
	 * @param y the new y-coordinate
	 */
	void move(int x, int y);
	
	
	/**
	 * Relative movement (robot)
	 * @param robot to be moved
	 * @param card the movement card
	 */
	void move(IRobot robot, ICardMovement card);

	
	/**
	 * relative movement (robot)
	 * @param robot to be moved
	 * @param card the rotation card
	 */
	void move(IRobot robot, ICardRotation card);

	/**
	 * execute a phase
	 */
	void doPhase();
	
	
	/**
	 * execute a round
	 */
	void doRound();
	
	
	/**
	 * @return an ordered list of events
	 */
	ArrayList<Event> makeEventList();
	
	
	/**
	 * reads and executes events in order
	 */
	void readEvents(arrayList<Event>);
	
	
	/**
	 * repair the robot
	 * @param robot to be repaired
	 */
	void repair(IRobot robot);
	
	/**
	 * updates the backup of the robot
	 * @param robot to update the backup of
	 */
	void updateBackUp(IRobot robot);
	
	
	/**
	 * deals the cards
	 */
	void dealCards();
	
	
	/**
	 * first checks if there is a flag and a robot, 
	 * then checks if the robot hits flags in right order.
	 * If so, updates the robot programming card. 
	 * Finally, it always places a new backup.
	 * 
	 * @param square
	 */
	void activateFlag(ISquare square);
	
	
	/**
	 * a simple board constructor
	 * 
	 * @param width the width of the board
	 * @param height the height of the board
	 * @param board the board given 2D integer array
	 */
	void createBoard(int width, int height, int[][] board);
	
	
	/**
	 * check if the robot has left the bounds of the board.
	 * If that happens, destroy the robot
	 */
	void checkLeaveBoard();
	
	
	/**
	 * restores the destroyed robot and places it back on the board in the 
	 * backup location
	 * @param robot
	 */
	void restoreRobot(IRobot robot);
	
	
	/**
	 * removes the card
	 * @param cards
	 */
	void removeCard(boolean[] cards);
	
	
}