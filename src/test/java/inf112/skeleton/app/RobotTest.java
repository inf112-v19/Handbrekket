package inf112.skeleton.app;

import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.robot.*;
import inf112.skeleton.app.robot.Robot;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class RobotTest {
    IRobot robot;

    public void initialize(){
        robot = new Robot(1,1,1);
    }

    @Test
    public void getHPFails(){
        assertFalse(1 == robot.getHP());

        robot.changeHP(4);
        assertFalse(7 == robot.getHP());
    }


    @Test
    public  void getHPAssertTrue(){
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
        assertEquals(3, robot.getLives());

        robot.decreaseLives();
        robot.decreaseLives();
        assertEquals(1, robot.getLives());

    }

    @Test
    public void getLivesFails(){
        robot.decreaseLives();
        assertFalse(3 == robot.getLives());
    }

    @Test
    public void getDirTrue(){
        assertEquals("E", robot.getDir().getSymbol());
        robot.setDir(Direction.SOUTH);
        assertEquals("S",robot.getDir().getSymbol());

    }
    @Test
    public void getDirFails(){
        assertFalse("W".equals(robot.getDir().getSymbol()));
    }

    @Test
    public void getIdTrue(){
        assertEquals(1,robot.getID());
    }

    @Test
    public void getIdFails(){
        assertFalse(2 == robot.getID());
    }

    @Test
    public void isPoweredDown(){
        assertEquals(false, robot.isPoweredDown());
        assertFalse(robot.isPoweredDown());
        robot.powerDown();
        assertEquals(true, robot.isPoweredDown());
    }
}