package inf112.skeleton.app;
<<<<<<< Updated upstream
import inf112.skeleton.app.card.ICardMovement;
import inf112.skeleton.app.card.MovementCard;
=======
import inf112.skeleton.app.board.IProgramRegisters;
import inf112.skeleton.app.board.ProgramRegisters;
>>>>>>> Stashed changes
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

        assertFalse(true == pR.isCardSlotsFilled());
    }

    @Test
    public void powerDownTest(){
        IRobot robot = new Robot(1);
        IProgramRegisters pR = new ProgramRegisters(robot);
        assertEquals(false, pR.isPoweredDown());
        pR.powerDown();
        assertEquals(true, pR.isPoweredDown());
        assertFalse(false == pR.isPoweredDown());
    }

    @Test
    public void LivesTests(){
        IRobot robot = new Robot(1);
        IProgramRegisters pR = new ProgramRegisters(robot);
        assertEquals(3, pR.howManyLivesLeft());
        pR.removeLife();
        pR.removeLife();
        assertEquals(1, pR.howManyLivesLeft());
    }

    @Test
    public void amountOfDamageTest(){
        IRobot robot = new Robot(1);
        IProgramRegisters pR = new ProgramRegisters(robot);
        assertEquals(0, pR.amountOfDamage());
        robot.changeHP(4);
        assertEquals(4, pR.amountOfDamage());
        assertFalse(9 == pR.amountOfDamage());
    }

}
