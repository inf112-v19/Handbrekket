package inf112.skeleton.app;

import java.util.ArrayList;
import inf112.skeleton.app.card.ICard;
import inf112.skeleton.app.robot.IRobot;

/**
 * Construct a program register
 * the board that players uses to "do stuff" in game
 */
public interface IProgramRegisters {

    /**
     * power down a robot
     * @param robot
     */
    void powerDown(IRobot robot);

    /**
     * checks if a robot is powered down
     * @param robot
     * @return
     */
    boolean isPoweredDown(IRobot robot);

    /**
     * Checks how many lives a robot has left
     * @param robot
     * @return int lives
     */
    int howManyLivesLeft(IRobot robot);

    /**
     * removes one life from a robot
     * @param robot
     */
    void removeLife(IRobot robot);

    /**
     *
     * @param robot
     * @return
     */
    int amountOfDamage (IRobot robot);

    /**
     * Checks if all five card slots are filles
     * @return true if they are filled
     */
    boolean isCardSlotsFilled ();

    /**
     * Removes unused cards
     * @param listOfCards
     */
    void discardOFCards (ArrayList<ICard> listOfCards);

    /**
     * Turns a card during a phase/register
     * @param card
     */
    void turnACard (ICard card);
}

