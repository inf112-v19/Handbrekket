
package inf112.skeleton.app;
<<<<<<< HEAD
import inf112.skeleton.app.board.IProgramRegisters;
import inf112.skeleton.app.board.ProgramRegisters;
=======
>>>>>>> 2e27f7e7ffbfbdf1f4328bf0a6cae66a5c44b73f
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
<<<<<<< HEAD
    public void initialize() {
    robot = new Robot(1,1,1);
    pR = new ProgramRegisters(robot);
 }
=======
    public void initialize(){
        robot = new Robot(1,1,1);
        pR = new ProgramRegisters(robot);
    }
>>>>>>> 2e27f7e7ffbfbdf1f4328bf0a6cae66a5c44b73f

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

<<<<<<< HEAD
=======
    @Test
    public void LivesTests(){
        assertEquals(3, pR.howManyLivesLeft());
        pR.removeLife();
        pR.removeLife();
        assertEquals(1, pR.howManyLivesLeft());
>>>>>>> 2e27f7e7ffbfbdf1f4328bf0a6cae66a5c44b73f
    }

    @Test
    public void amountOfDamageTest(){
        assertEquals(0, pR.amountOfDamage());
        robot.changeHP(4);
        assertEquals(4, pR.amountOfDamage());
        assertFalse(9 == pR.amountOfDamage());
    }
}