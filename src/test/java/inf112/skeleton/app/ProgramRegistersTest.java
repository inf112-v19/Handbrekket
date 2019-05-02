
package inf112.skeleton.app;

import inf112.skeleton.app.board.IProgramRegister;
import inf112.skeleton.app.board.ProgramRegister;
import inf112.skeleton.app.card.ICard;
import inf112.skeleton.app.card.MovementCard;
import inf112.skeleton.app.card.RotationCard;
import inf112.skeleton.app.robot.IRobot;
import inf112.skeleton.app.robot.Robot;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;

/**
 * Created by mari on 08.03.2019.
 */
public class ProgramRegistersTest {
    IRobot robot;
    IProgramRegister programRegister;
    ArrayList<ICard> activeCards;

    @Before
    public void initialize(){
        int[] testCoordinates = {1,1};
        robot = new Robot(1,testCoordinates);
        programRegister = new ProgramRegister(robot, true);
        activeCards=new ArrayList<>();
        ICard moveCard1 = new MovementCard(450,3);
        ICard moveCard2 = new MovementCard(120,1);
        ICard moveCard3 = new MovementCard(300,2);
        ICard rotateCard1 = new RotationCard(230,true,1);
        ICard rotateCard2 = new RotationCard(190,false,1);
        ICard rotateCard3 = new RotationCard(60,true,1);
        activeCards.add(moveCard1);
        activeCards.add(moveCard2);
        activeCards.add(moveCard3);
        activeCards.add(rotateCard1);
        activeCards.add(rotateCard3);

    }

    @Test
    public void isCardSlotsFilledTest(){
        assertEquals(false, programRegister.isCardSlotsFilled());


        assertFalse(true == programRegister.isCardSlotsFilled());

    }


    @Test
    public void powerDownTest() {
        assertEquals(false, programRegister.isPoweredDown());
        programRegister.powerDown();
        assertEquals(true, programRegister.isPoweredDown());
        assertFalse(false == programRegister.isPoweredDown());
    }

    @Test
    public void LivesTests(){
        assertEquals(3, programRegister.getLives());
        programRegister.removeLife();
        programRegister.removeLife();
        assertEquals(1, programRegister.getLives());
    }

    @Test
    public void amountOfDamageTest(){
        assertEquals(0, programRegister.getDamage());
        programRegister.changeDamage(4);
        assertEquals(4, programRegister.getDamage());
        assertFalse(9 == programRegister.getDamage());
    }

    @Test
    public void checkIfCardsAreActive () {

    }

    @Test
    public void HumanTest() {

        programRegister=new ProgramRegister(robot,true);

        assertTrue(programRegister.isPlayerHuman());

        programRegister.turnHumanPlayerIntoAI();

        assertFalse(programRegister.isPlayerHuman());


    }

    @Test
    public void isDeadTest() {

        programRegister.removeLife();
        programRegister.removeLife();
        programRegister.removeLife();

        assertEquals(0,programRegister.getLives());
    }


    @Test
    public void flagCounterTest() {
        int flagCounter = programRegister.getFlagCounter();

        assertEquals(0,flagCounter);

        programRegister.increaseFlagCounter();
        programRegister.increaseFlagCounter();
        programRegister.increaseFlagCounter();

        flagCounter=programRegister.getFlagCounter();

        assertEquals(3,flagCounter);
    }

    @Test
    public void getRobotTest() {
        assertEquals(robot,programRegister.getRobot());
    }

    @Test
    public void restoreRobotTest() {

        programRegister.destroyRobot();

        assertTrue(programRegister.isDestroyed());

        programRegister.restoreRobot();

        assertFalse(programRegister.isDestroyed());

    }

    @Test
    public void powerDownRobotTest() {

        programRegister.powerDown();

        assertTrue(programRegister.isPoweredDown());
    }

    @Test
    public void powerRobotOnTest() {
        programRegister.powerDown();
        programRegister.powerOn();

        assertFalse(programRegister.isPoweredDown());
    }

    @Test
    public void getLivesOfRobotTest () {
        assertEquals(3, programRegister.getLives());

        programRegister.removeLife();

        assertEquals(2,programRegister.getLives());
    }

    @Test
    public void getDamageOfRobotTest() {

        assertEquals(0, programRegister.getDamage());

        programRegister.setDamage(5);

        assertEquals(5,programRegister.getDamage());

    }

    @Test
    public void changeDamageOfRobotTest() {

        programRegister.changeDamage(8);

        assertEquals(8, programRegister.getDamage());

    }

    @Test
    public void cardSlotFilledTest() {

        programRegister.setAvailableCards(activeCards);

        assertTrue(programRegister.isCardSlotsFilled());
    }

    @Test
    public void discardOfUnusedCardTest() {
    }

    @Test
    public void discardOfAllCardsTest() {

    }

    @Test
    public void setAvailableCardsTest() {

    }

    @Test
    public void turnACardTest() {

    }

    @Test
    public void makeACardActiveTest() {

    }

    @Test
    public void getAvailableCardsTest() {

    }

    @Test
    public void getActiveCardsTest() {

    }

    @Test
    public void getActiveCardsInPosition() {

    }
}
