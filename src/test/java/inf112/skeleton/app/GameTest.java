package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.card.ICardMovement;
import inf112.skeleton.app.card.ICardRotation;
import inf112.skeleton.app.card.MovementCard;
import inf112.skeleton.app.card.RotationCard;
import inf112.skeleton.app.game.Game;
import inf112.skeleton.app.robot.IRobot;
import inf112.skeleton.app.robot.Robot;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    private IRobot robot;
    private Game game;
    private ICardMovement moveTwoSteps;
    private ICardMovement moveOneStep;
    private ICardMovement moveThreeSteps;
    private ICardMovement moveOneBackwards;
    private ICardRotation moveRight;
    private ICardRotation moveLeft;
    private ICardRotation uTurn;
    private GameState gameState;
    private ArrayList<ICard> deck = new ArrayList<>();


    @Before
    public void setUp() {
        int[] testCoordinates = {1,1};
        robot = new Robot(0,testCoordinates);
        robot.setDir(Direction.EAST);
        TiledMap map = new TiledMap();
        game = new Game(map,1,2);
    }

    @Test
    public void testMoveTwoSteps() {
        game.relativeMoveStraight(robot, Direction.EAST, 2);
        int [] newPos = {3,1};
        assertEquals(robot.getPosition(), newPos);
    }

    @Test
    public void testMoveOneStep() {
        game.relativeMoveStraight(robot, Direction.EAST, 1);
        int [] newPos = {2,1};
        assertEquals(robot.getPosition(), newPos);
    }


    @Test
    public void testMoveThreeStep() {
        game.relativeMoveStraight(robot, Direction.EAST, 3);
        int [] newPos = {4,1};
        assertEquals(robot.getPosition(), newPos);
    }

    @Test
    public void testMoveOneBackwards() {
        game.relativeMoveStraight(robot, Direction.EAST, -1);
        int [] newPos = {0,1};
        assertEquals(robot.getPosition(), newPos);
    }

    @Test
    public void testRotateRight() {
        RotationCard moveRight = new RotationCard(1,true,1);
        game.rotationMove(robot, moveRight);
        assertEquals(robot.getDir(), Direction.SOUTH);
    }

    @Test
    public void testRotateLeft() {
        RotationCard moveLeft = new RotationCard(1,false,1);
        game.rotationMove(robot, moveLeft);
        assertEquals(robot.getDir(), Direction.NORTH);
    }

    @Test
    public void testUTurn() {
        RotationCard uTurn = new RotationCard(1,true,2);
        game.rotationMove(robot, uTurn);
        assertEquals(robot.getDir(), Direction.WEST);
    }


    @Test
    public void checkIfOnHoleTest() {
        boardHoles.add(3);
        game.relativeMoveStraight(robot, Direction.EAST, 2);
        assertTrue(game.checkIfOnHoleOrOutSideBoard(robot));
    }

    @Test
    public void checkIfOnFlagTest() {
        boardFlags.add(2);
        game.relativeMoveStraight(robot, Direction.EAST, 1);
        assertTrue(game.checkIfOnFlag(robot));
    }

    @Test
    public void checkIfOutsideBoardTest() {

        //Tests that robot really is outside the given board
        Board board = new Board(8, 7, mapIn);
        int[] position = new position[2]; //robot's position
        position[0] = 10;
        position[1] = 10;
        assertTrue(game.checkIfOutsideBoard(position));

        //Test that robot is not outside the given board
        position[0] = 4;
        position[1] = 4;

        assertFalse(game.checkIfOutsideBoard(position));

    }

    @Test
    public void checkForWallTest() {
        boardWalls.add(3);
        game.relativeMoveStraight(robot, Direction.EAST, 2);
        assertTrue(game.checkForWall(robot.getPosition(), Direction.NORTH));
    }

    @Test
    public void noCrashWithWallTest() {
        game.relativeMoveStraigt(robot, Direction.EAST, 3);
        int[] robotPos = new int[2];
        robotPos[0] = robot.getPosition(); //new x-coordinate
        robotPos[1] = robot.getPosition(); //new y-coordinate
        assertEquals(2, robotPos[0]); //only moved two steps (not three!)
        assertEquals(1, robotPos[1]);
    }

    @Test
    public void getGameStateTest() {
        gameState = GameState.DEALING_CARDS;
        assertEquals(game.getGameState(), DEALING_CARDS);
    }

    @Test
    public void absoluteMoveTest() {
        int[] coordinates = new int[2];
        coordinates[0] = 8;
        coordinates[1] = 14;
        game.absoluteMove(robot, coordinates);
        assertArrayEquals(robot.getPosition(), coordinates);
    }

    @Test
    public void relativeMoveTest() {
        MovementCard card = new MovementCard(290,2);
        game.relativeMove(robot, card);
        int newPos = new int[2];
        newPos[0] = 3;
        newPos[1] = 1;
        assertArrayEquals(robot.getPosition(), newPos);
    }

    @Test
    public void canMoveTest() {

        int[] destinationCoordinates = new int[2];
        int[] startCoordinates = new int[2];

        destinationCoordinates[0] = 4;
        destinationCoordinates[1] = 7;
        startCoordinates[0] = 3;
        startCoordinates[1] = 8;
        assertTrue(canMove(startCoordinates, destinationCoordinates));

        destinationCoordinates[0] = 10;
        destinationCoordinates[1] = 8;
        startCoordinates[0] = 5;
        startCoordinates[1] = 12;
        assertFalse(canMove(startCoordinates, destinationCoordinates));

    }

    @Test
    public void addCardToDeckTest() {
        ICard card;
        game.addCardToDeck(card);
        assertEquals(deck.size(),1);
    }

    @Test
    public void getConveyorInPositionTest() {
        int[] position = new int[2];
        position[0] = 3;
        position[1] = 5;
        IConveyorBelt conveyorBelt;
        ArrayList<IConveyorBelt> conveyorBelts = new ArrayList<>();
        conveyorBelts.add(3);
        assertArrayEquals(conveyorBelt.getPosition(), position);
/*
        private IConveyorBelt getConveyorInPosition(int[] position) {
            for(IConveyorBelt conveyorBelt : conveyorBelts) {
                if(Arrays.equals(conveyorBelt.getPosition(), position))
                    return conveyorBelt;
            }
  */
    }




}