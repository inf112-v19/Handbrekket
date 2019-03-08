package inf112.skeleton.app;

import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.robot.*;
import inf112.skeleton.app.robot.Robot;
import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class RobotTest {
    @Test
    public void getHPFails(){
        IRobot robot = new Robot(1);
        assertFalse(1 == robot.getHP());

        robot.changeHP(4);
        assertFalse(7 == robot.getHP());
    }


    @Test
    public  void getHPAssertTrue(){
        IRobot robot = new Robot(2);
        assertEquals(0, robot.getHP());

        robot.changeHP(3);
        assertEquals(3, robot.getHP());

        robot.changeHP(-2);
        assertEquals(1, robot.getHP());

        robot.changeHP(-4);
        assertEquals(0, robot.getHP());
    }

    @Test
    public void getLivesAsserTrue(){
        IRobot robot = new Robot(1);
        assertEquals(3, robot.getLives());

        robot.decreaseLives();
        robot.decreaseLives();
        assertEquals(1, robot.getLives());

    }

    @Test
    public void getLivesFails(){
        IRobot robot = new Robot(1);
        robot.decreaseLives();
        assertFalse(3 == robot.getLives());
    }

    @Test
    public void getDirTrue(){
        IRobot robot = new Robot(1);
        assertEquals("E", robot.getDir().getSymbol());
        robot.setDir(Direction.SOUTH);
        assertEquals("S",robot.getDir().getSymbol());

    }
    @Test
    public void getDirFails(){
        IRobot robot = new Robot(1);
        assertFalse("W".equals(robot.getDir().getSymbol()));
    }

    @Test
    public void getIdTrue(){
        IRobot robot = new Robot(1);
        assertEquals(1,robot.getID());
    }

    @Test
    public void getIdFails(){
        IRobot robot = new Robot(1);
        assertFalse(2 == robot.getID());
    }

    @Test
    public void isPoweredDown(){
        IRobot robot = new Robot(1);
        assertEquals(false, robot.isPoweredDown());
        assertFalse(robot.isPoweredDown());
        robot.powerDown();
        assertEquals(true, robot.isPoweredDown());
    }
}