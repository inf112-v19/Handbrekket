package inf112.skeleton.app;

import inf112.skeleton.app.card.*;
import inf112.skeleton.app.robot.*;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mari on 24.02.2019.
 */
public class ProgramRegisters implements IProgramRegisters{

    private Card[] listOfCards = new Card[9];
    private Card[] cardSlots = new Card[5];
    private boolean[] flipped = new boolean[5];
    private IRobot robot;

    public ProgramRegisters(IRobot robot){
        this.robot = robot;

    }
    /**
     * power down a robot
     *
     */
    @Override
    public void powerDown() {
        robot.setHP(0);
        robot.powerDown();
    }

    /**
     * checks if a robot is powered down
     *
     * @return
     */
    @Override
    public boolean isPoweredDown() {
        return robot.isPoweredDown();
    }

    /**
     * Checks how many lives a robot has left
     *
     * @return int lives
     */
    @Override
    public int howManyLivesLeft() {
        return robot.getLives();
    }

    /**
     * removes one life from a robot
     *
     */
    @Override
    public void removeLife() {
        robot.decreaseLives();
    }

    /**
     * @return
     */
    @Override
    public int amountOfDamage() {
        return robot.getHP();
    }

    /**
     * Checks if all five card slots are filles
     *
     * @return true if they are filled
     */
    @Override
    public boolean isCardSlotsFilled() {

        for (int i = 0; i < cardSlots.length; i++) {
            if (cardSlots[i] == null) {
                return false;

            }
        }
        return true;
    }

    /**
     * Removes unused cards
     *
     * @param listOfCards
     */
    @Override
    public void discardOFCards(ArrayList<ICard> listOfCards) {
        listOfCards.clear();
    }

    /**
     * Turns a card during a phase/register
     *
     * @param card
     */
    @Override
    public void turnACard(ICard card) {

    }

}
