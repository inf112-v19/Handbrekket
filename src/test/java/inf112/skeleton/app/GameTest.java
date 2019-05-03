package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.board.Board;
import inf112.skeleton.app.board.ConveyorBelts.IConveyorBelt;
import inf112.skeleton.app.card.ICardMovement;
import inf112.skeleton.app.card.ICardRotation;
import inf112.skeleton.app.card.ICard;
import inf112.skeleton.app.card.MovementCard;
import inf112.skeleton.app.card.RotationCard;
import inf112.skeleton.app.game.GameState;
import inf112.skeleton.app.game.Game;
import inf112.skeleton.app.robot.IRobot;
import inf112.skeleton.app.robot.Robot;
import java.util.ArrayList;
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
    private TiledMap map;

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
        int[] newPos = {3,1};
        assertEquals(robot.getPosition(), newPos);
    }

    @Test
    public void testMoveOneStep() {
        game.relativeMoveStraight(robot, Direction.EAST, 1);
        int[] newPos = {2,1};
        assertEquals(robot.getPosition(), newPos);
    }


    @Test
    public void testMoveThreeStep() {
        game.relativeMoveStraight(robot, Direction.EAST, 3);
        int[] newPos = {4,1};
        assertEquals(robot.getPosition(), newPos);
    }

    @Test
    public void testMoveOneBackwards() {
        game.relativeMoveStraight(robot, Direction.EAST, -1);
        int[] newPos = {0,1};
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
        ArrayList<int[]> boardHoles = new ArrayList<>();
        int[] hole = new int[2];
        hole[0] = 3;
        hole[1] = 1;
        boardHoles.add(hole);
        game.relativeMoveStraight(robot, Direction.EAST, 2);
        assertTrue(game.checkIfOnHoleOrOutsideBoard(robot));
    }
    @Test
    public void checkIfOnFlagTest() {
        ArrayList<int[]> boardFlags = new ArrayList<>();
        int[] flag = new int[2];
        flag[0] = 2;
        flag[1] = 1;
        boardFlags.add(flag);
        game.relativeMoveStraight(robot, Direction.EAST, 1);
        assertTrue(game.checkIfOnFlag(robot));
    }
    @Test
    public void checkIfOutsideBoardTest() {
        //Tests that robot really is outside the given board
        Board board = new Board(8, 7, map);
        int[] position = new int[2]; //robot's position
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
        ArrayList<int[]> boardWalls = new ArrayList();
        int[] wallPos = new int[2];
        wallPos[0] = 3;
        wallPos[1] = 1;
        boardWalls.add(wallPos);
        game.relativeMoveStraight(robot, Direction.EAST, 2);
        assertTrue(game.checkForWall(robot.getPosition(), Direction.NORTH));
    }
    @Test
    public void noCrashWithWallTest() {
        game.relativeMoveStraight(robot, Direction.EAST, 3);
        int[] robotPos = new int[2];
        robotPos= robot.getPosition();
        assertEquals(2, robotPos[0]); //only moved two steps (not three!)
        assertEquals(1, robotPos[1]);
    }
    @Test
    public void getGameStateTest() {
        gameState = GameState.DEALING_CARDS;
        assertEquals(game.getGameState(), GameState.DEALING_CARDS);
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
        int priority = 290;
        int moveValue = 2;
        MovementCard card = new MovementCard(priority, moveValue);
        game.relativeMove(robot, card);
        int[] newPos = new int[2];
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
        assertTrue(game.canMove(startCoordinates, destinationCoordinates));
        destinationCoordinates[0] = 10;
        destinationCoordinates[1] = 8;
        startCoordinates[0] = 5;
        startCoordinates[1] = 12;
        assertFalse(game.canMove(startCoordinates, destinationCoordinates));
    }
    @Test
    public void addCardToDeckTest() {

        ArrayList<ICard> deck = new ArrayList<>();
        ICard card;
        game.addCardToDeck(ICard card);
        assertEquals(deck.size(),1);
    }

    @Test
    public void getConveyorInPositionTest() {
        int[] position = new int[2];
        position[0] = 3;
        position[1] = 5;
        IConveyorBelt c;
        ArrayList<IConveyorBelt> conveyorBelts = new ArrayList<>();
        conveyorBelts.add(3);
        assertArrayEquals(c.getPosition(), position);

    }

    @Test
    public void updateBackupTest(){
        int[] robotPos = new int[2];
        robotPos[0] = 4;
        robotPos[1] = 10;
        robot.setPosition(robotPos);
        int[] backUp = new int[2];
        backUp = robot.getPosition();
        assertArrayEquals(robotPos, backUp);
    }

    @Test
    public void repairTest() {
        repair(IProgramRegister programRegister)
        programRegister.changeDamage(-1);
    }

}