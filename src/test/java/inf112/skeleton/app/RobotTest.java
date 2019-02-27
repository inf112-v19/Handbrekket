package inf112.skeleton.app;

import inf112.skeleton.app.robot.IRobot;
import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.assertEquals;

public class RobotTest {
    @Test
    public void createRobot(){
        IRobot robot = new inf112.skeleton.app.robot.Robot(1);
        assertEquals(1,robot.getHP());
    }
}