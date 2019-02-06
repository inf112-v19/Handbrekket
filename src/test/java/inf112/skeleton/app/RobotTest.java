package inf112.skeleton.app;

import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.assertEquals;

public class RobotTest {
    @Test
    public void createRobot(){
        Robot robot = new Robot(1);
        assertEquals(1,robot.getHP());
    }
}