
package inf112.skeleton.app;
import inf112.skeleton.app.board.IProgramRegisters;
import inf112.skeleton.app.board.ProgramRegisters;
import inf112.skeleton.app.robot.IRobot;
import inf112.skeleton.app.robot.Robot;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.*;

/**
 * Created by mari on 08.03.2019.
 */
public class ProgramRegistersTest {
    IRobot robot;
    IProgramRegisters pR;

    @Before
    public void initialize() {
    robot = new Robot(1,1,1);
    pR = new ProgramRegisters(robot);
 }

    @Test
    public void isCardSlotsFilledTest(){
        assertEquals(false, pR.isCardSlotsFilled());


        assertFalse(true == pR.isCardSlotsFilled());

    }


    @Test
    public void powerDownTest(){
        assertEquals(false, pR.isPoweredDown());
        pR.powerDown();
        assertEquals(true, pR.isPoweredDown());
        assertFalse(false == pR.isPoweredDown());

    }

    @Test
    public void amountOfDamageTest(){
        assertEquals(0, pR.amountOfDamage());
        robot.changeHP(4);
        assertEquals(4, pR.amountOfDamage());
        assertFalse(9 == pR.amountOfDamage());
    }
}