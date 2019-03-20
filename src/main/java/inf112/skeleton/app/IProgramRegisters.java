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
     * returns the robot
     * @return
     */
    IRobot getRobot();

    /**
     * power down a robot
     *
     */
    void powerDown();

    /**
     * checks if a robot is powered down
     *
     * @return
     */
    boolean isPoweredDown();

    /**
     * Checks how many lives a robot has left
     *
     * @return int lives
     */
    int howManyLivesLeft();

    /**
     * removes one life from a robot
     *
     */
    void removeLife();

    /**
     *
     * @return
     */
    int amountOfDamage ();

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
     * Deals new cards
     * @param listOfCards
     */
    void dealCards(ArrayList<ICard> listOfCards);

    /**
     * Turns a card during a phase/register
     * @param card
     */
    void turnACard (ICard card);
}

