package inf112.skeleton.app;

import inf112.skeleton.app.card.*;
import inf112.skeleton.app.card.ICard;
import inf112.skeleton.app.robot.*;
import inf112.skeleton.app.robot.IRobot;

import java.util.ArrayList;

/**
 * Created by mari on 24.02.2019.
 */
public class ProgramRegisters implements IProgramRegisters{

    /**
     * power down a robot
     *
     * @param robot
     */
    @Override
    public void powerDown(IRobot robot) {
        robot.changeHP(0);
//        isPoweredDown(robot) = true;

    }

    /**
     * checks if a robot is powered down
     *
     * @param robot
     * @return
     */
    @Override
    public boolean isPoweredDown(IRobot robot) {
        // ventar på GUI
        return false;
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
        robot.changeLives();
//  kill robot in main

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
// lagar cardslots i Card
//  kor lagrar ein cardslots?
        ArrayList<ICard> cardSlots = new ArrayList<>();

        for (int i = 0; i < cardSlots.size(); i++) {
            if (cardSlots.get(i) == null) {
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
//    public void turnACard(ArrayList<ICard> listOfCards) {
//        card nextMove = listOfCards[0];
//        listOfCards.remove(0);

    }
}
