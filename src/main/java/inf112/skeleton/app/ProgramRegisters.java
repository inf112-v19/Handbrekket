package inf112.skeleton.app;

import inf112.skeleton.app.card.*;
import inf112.skeleton.app.card.ICard;
import inf112.skeleton.app.robot.*;
import inf112.skeleton.app.robot.IRobot;

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

    /**
     * power down a robot
     *
     * @param robot
     */
    @Override
    public void powerDown(IRobot robot) {
        robot.setHP(0);
        robot.powerDown();
    }

    /**
     * checks if a robot is powered down
     *
     * @param robot
     * @return
     */
    @Override
    public boolean isPoweredDown(IRobot robot) {
        return robot.isPoweredDown();
    }

    /**
     * Checks how many lives a robot has left
     *
     * @param robot
     * @return int lives
     */
    @Override
    public int howManyLivesLeft(IRobot robot) {
        return robot.getLives();
    }

    /**
     * removes one life from a robot
     *
     * @param robot
     */
    @Override
    public void removeLife(IRobot robot) {
        robot.decreaseLives();
    }

    /**
     * @param robot
     * @return
     */
    @Override
    public int amountOfDamage(IRobot robot) {
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
            if (cardSlots[1] == null) {
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
