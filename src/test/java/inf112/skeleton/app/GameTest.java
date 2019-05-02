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

    @Before
    public void setUp() {
        int[] testCoordinates = {1,1};
        robot = new Robot(0,testCoordinates);
        robot.setDir(Direction.EAST);
        TiledMap map = new TiledMap();
        game = new Game(map, 1);
    }
+
    @Test
    public void testMoveTwoSteps() {
        game.relativeMoveStraight(robot, Direction.EAST, 2);
        int newPos = {3,1}
        assertEquals(robot.getPosition(), newPos);
    }

    @Test
    public void testMoveOneStep() {
        game.relativeMoveStraight(robot, Direction.EAST, 1);
        int newPos = {2,1}
        assertEquals(robot.getPosition(), newPos);
    }


    @Test
    public void testMoveThreeStep() {
        game.relativeMoveStraight(robot, Direction.EAST, 3);
        int newPos = {4,1}
        assertEquals(robot.getPosition(), newPos);
    }

    @Test
    public void testMoveOneBackwards() {
        game.relativeMoveStraight(robot, Direction.EAST, -1);
        int newPos = {0,1}
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

        int[] holePos = new int[2];
        holePos[0] = 3;
        holePos[1] = 1;

        gsme.relativeMoveStraight(robot, Direction.EAST, 2);
        assertEquals(holePos, robot.getPosition);

    }


}