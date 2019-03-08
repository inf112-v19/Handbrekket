package inf112.skeleton.app;
import inf112.skeleton.app.robot.IRobot;
import inf112.skeleton.app.robot.Robot;
import org.junit.Test;
import static junit.framework.TestCase.*;
import inf112.skeleton.app.IProgramRegisters;

import javax.smartcardio.Card;

/**
 * Created by mari on 08.03.2019.
 */
public class ProgramRegistersTest {
    @Test
    public void isCardSlotsFilledTest(){
        IRobot robot = new Robot(1);
        IProgramRegisters pR = new ProgramRegisters(robot);
        assertEquals(false, pR.isCardSlotsFilled());
    }

}
