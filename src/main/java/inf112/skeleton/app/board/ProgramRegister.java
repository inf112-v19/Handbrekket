package inf112.skeleton.app.board;

import inf112.skeleton.app.card.ICard;
import inf112.skeleton.app.game.IGame;
import inf112.skeleton.app.robot.IRobot;
import inf112.skeleton.app.util.GameRuleConstants;

import java.util.ArrayList;
import java.util.Arrays;

public class ProgramRegister implements IProgramRegister {
    private final int maxLives = GameRuleConstants.MAX_LIVES.getValue();    //The max amount of lives
    private int maxDamage = GameRuleConstants.MAX_DAMAGE.getValue();    //The max amount of damage the register can register
    private IRobot robot;           //The robot associated with the program register
    private int lives;              //The current amount of lives
    private boolean powerDowned;    //Whether the robot in the register should be powered down or not
    private int damage;
    private int flagCounter;
    private boolean isRobotDestroyed;
    private boolean isPlayerHuman;

    /**
     * All of the variables and lists relating to cards
     * availableCards: All cards in the register (usually 9)
     * activeCards: The cards used in phase execution (usually 5)
     * isCardFlipped: Stores whether an active card is flipped or not
     */
    private ArrayList<ICard> availableCards = new ArrayList<>();
    private ICard[] activeCards = new ICard[GameRuleConstants.ACTIVE_CARDS_IN_REGISTER.getValue()];
    private boolean[] isCardFlipped = new boolean[GameRuleConstants.ACTIVE_CARDS_IN_REGISTER.getValue()];
    private int maxAvailableCardAmount = GameRuleConstants.MAX_CARDS_IN_REGISTER.getValue();
    private int maxActiveCardAmount = GameRuleConstants.ACTIVE_CARDS_IN_REGISTER.getValue();

    public ProgramRegister(IRobot robot, boolean isPlayerHuman) {
        this.robot = robot;
        this.isPlayerHuman = isPlayerHuman;
        lives = maxLives;
        powerDowned = false;
        damage = 0;
        flagCounter = 0;
        isRobotDestroyed = false;
    }

    @Override
    public boolean[] getIsCardFlipped() {
        return isCardFlipped;
    }

    @Override
    public boolean isPlayerHuman() {
        return isPlayerHuman;
    }

    @Override
    public void turnHumanPlayerIntoAI() {
        if (!isPlayerHuman)
            throw new IllegalArgumentException("The player is already an AI!");
        else
            isPlayerHuman = false;

    }

    @Override
    public boolean isDead() {
        return lives == 0;
    }

    @Override
    public int getFlagCounter() {
        return flagCounter;
    }

    @Override
    public void increaseFlagCounter() {
        flagCounter++;
    }

    @Override
    public IRobot getRobot() {
        return robot;
    }

    @Override
    public void destroyRobot() {
        int[] backUpLocation = robot.getBackup();
        robot.setPosition(backUpLocation); //Does the move here to avoid weird animations
        removeLife();
        isRobotDestroyed = true;
    }

    @Override
    public boolean isDestroyed() {
        return isRobotDestroyed || isDead();
    }

    @Override
    public boolean restoreRobot() {
        if (lives > 0) {
            setDamage(2);
            isRobotDestroyed = false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void powerDown() {
        setDamage(0);
        powerDowned = true;
    }

    @Override
    public boolean isPoweredDown() {
        return powerDowned;
    }

    @Override
    public void powerOn() {
        powerDowned = false;
    }

    @Override
    public int getLives() {
        return lives;
    }

    public void setLives(int live) {
        lives = live;
    }

    @Override
    public void removeLife() {
        lives--;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void changeDamage(int dam) {
        damage += dam;
        if (damage < 0)
            damage = 0;

        if (damage >= maxDamage) {
            destroyRobot();
            isRobotDestroyed = true;
            damage = maxDamage;
        }
    }

    /**
     * Checks if all five card slots are filled
     *
     * @return true if they are filled
     */
    @Override
    public boolean isCardSlotsFilled() {
        for (int i = 0; i < activeCards.length; i++) {
            if (activeCards[i] == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void discardUnusedCards(IGame game) {
        int availableCardsSize = availableCards.size();
        for (int i = 0; i < availableCardsSize; i++) {
            game.addCardToDeck(availableCards.get(0));
            availableCards.remove(0);
        }
    }

    @Override
    public void discardAllCards(IGame game) {
        discardUnusedCards(game);

        if (damage > 4) {
            for (int i = 0; i < 9 - damage; i++) {
                game.addCardToDeck(activeCards[i]);
                activeCards[i] = null;
            }
        } else {
            for (int i = 0; i < activeCards.length; i++) {
                if (activeCards[i] != null) {
                    game.addCardToDeck(activeCards[i]);
                    activeCards[i] = null;
                }
            }
        }

        for (int i = 0; i < isCardFlipped.length; i++) {
            isCardFlipped[i] = false;
        }

    }

    /**
     * Turns a card during a phase/register
     *
     * @param numCard
     */
    @Override
    public void turnACard(int numCard) {
        isCardFlipped[numCard] = !isCardFlipped[numCard];
    }

    @Override
    public boolean isCardFlipped(int numCard) {
        return isCardFlipped[numCard];
    }

    @Override
    public boolean makeCardActive(int numCard) {

        for (int i = 0; i < activeCards.length; i++) {
            if (activeCards[i] == null) {
                activeCards[i] = availableCards.get(numCard);
                availableCards.remove(numCard);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns all of the available cards
     *
     * @return ArrayList<ICard> of available cards
     */
    @Override
    public ArrayList<ICard> getAvailableCards() {
        return availableCards;
    }

    @Override
    public void setAvailableCards(ArrayList<ICard> listOfCards) {
        this.availableCards = listOfCards;
    }

    /**
     * Returns all of the active cards
     *
     * @return ArrayList<ICard> of active cards
     */
    @Override
    public ArrayList<ICard> getActiveCards() {
        return new ArrayList<>(Arrays.asList(activeCards));
    }

    @Override
    public ICard getActiveCardInPosition(int position) {
        return activeCards[position];
    }
}