package inf112.skeleton.app.board;

import inf112.skeleton.app.board.IProgramRegisters;
import inf112.skeleton.app.card.*;
import inf112.skeleton.app.game.GameRuleConstans;
import inf112.skeleton.app.robot.*;

import java.util.ArrayList;

/**
 * Created by mari on 24.02.2019.
 */
public class ProgramRegisters implements IProgramRegisters {

    private ArrayList<ICard> listOfCards;
    private ICard[] cardSlots = new ICard[GameRuleConstans.ACTIVE_CARDS_IN_REGISTER.getValue()];
    private boolean[] flipped = new boolean[GameRuleConstans.ACTIVE_CARDS_IN_REGISTER.getValue()];
    private IRobot robot;
    private int maxCards;
    private int activeCards;
    private int maxLives;
    private int maxDamage;

    public ProgramRegisters(IRobot robot){
        this.robot = robot;
        this.activeCards=GameRuleConstans.ACTIVE_CARDS_IN_REGISTER.getValue();
        this.maxCards=GameRuleConstans.MAX_CARDS_IN_REGISTER.getValue();
        this.maxLives=GameRuleConstans.MAX_LIVES.getValue();
        this.maxDamage=GameRuleConstans.MAX_DAMAGE.getValue();
    }

    @Override
    public IRobot getRobot() {
        return robot;
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

    @Override
    public void dealCards(ArrayList<ICard> listOfCards) {
        this.listOfCards = listOfCards;
    }


    /**
     * Turns a card during a phase/register
     *
     * @param numCard
     */
    @Override
    public void turnACard(int numCard) {
        flipped[numCard]=!flipped[numCard];


    }

    //Todo: better method name & write better comments
    //Attempts to fill a cardSlot, return true if sucess, false if fail
    @Override
    public boolean addCard(ICard inputCard) {
        for(int i = 0; i < cardSlots.length;i++) {
            if(cardSlots[i] == null){
                cardSlots[i] = inputCard;
                return true;
            }
        }
        return false;
    }

    /**
     * Turns in arraylist storen in iprogramregister
     */
    @Override
    public ArrayList<ICard> getProgramCards() {
        return listOfCards;
    }
}

