package inf112.skeleton.app.board;

import java.util.ArrayList;
import inf112.skeleton.app.card.ICard;
import inf112.skeleton.app.game.IGame;
import inf112.skeleton.app.robot.IRobot;

/**
 * Construct a program register
 * the board that players uses to "do stuff" in game
 */
public interface IProgramRegister {
    /**
     * Checks if the player is dead
     *
     * @return true if lives = 0; false otherwise
     */
    boolean isDead();

    /**
     * Returns the flag counter
     *
     * @return flagCounter
     */
    int getFlagCounter();


    /**
     * Increases the flag counter by 1
     */
    void increaseFlagCounter();

    /**
     * returns the robot
     *
     * @return
     */
    IRobot getRobot();

    /**
     * power down a robot
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
    int getLives();

    /**
     * removes one life from a robot
     */
    void removeLife();

    /**
     * Absolute HP change (the HP value becomes the new HP)
     *
     * @param HP the new HP
     * @return new HP
     */
    void setHP(int HP);

    /**
     * Changes the HP,
     * Positive to add health
     * Negative to remove health
     *
     * @param HP the HP to be added/removed
     * @return new HP
     */
    void changeHP(int HP);

    /**
     * Returns the current HP
     *
     * @return
     */
    int getHP();

    /**
     * Checks if all five card slots are filled
     *
     * @return true if they are filled
     */
    boolean isCardSlotsFilled();

    /**
     * Removes unused cards and put them back to stack
     */
    void discardUnusedCards(IGame game);

    /**
     * Deals new cards
     *
     * @param listOfCards
     */
    void setAvailableCards(ArrayList<ICard> listOfCards);

    /**
     * Turns a card during a phase/register
     *
     * @param numCard
     */

    void turnACard(int numCard);


    /**
     * Attempts to put a card into the first available active card slot
     *
     * @param numCard number of card to put into the slot
     * @return true if success, false otherwise
     */
    boolean makeCardActive(int numCard);

    /**
     * Returns all of the available cards
     * @return ArrayList<ICard> of available cards
     */
    ArrayList<ICard> getAvailableCards();

    /**
     * Returns all of the active cards
     * @return ArrayList<ICard> of active cards
     */
    ArrayList<ICard> getActiveCards();

    /**
     * Returns a card from the active card list
     * @param position the position of the card wanted
     * @return card in position
     */
    ICard getActiveCardInPosition(int position);
}
