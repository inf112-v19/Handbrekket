package inf112.skeleton.app.robot;

import inf112.skeleton.app.board.IProgramRegister;
import inf112.skeleton.app.game.GameRuleConstants;

/**
 * Chooses random cards, powers down when damage is more than half of health pool
 */
public class SimpleAI implements IAI {
    @Override
    public void decideIfPowerDown(IProgramRegister register) {
        if((float)(register.getDamage() / GameRuleConstants.MAX_DAMAGE.getValue()) > 0.5)
            register.powerDown();
    }

    @Override
    public void activateCards(IProgramRegister register) {
        while(register.getActiveCards().size() < GameRuleConstants.ACTIVE_CARDS_IN_REGISTER.getValue()) {
            int cardNumber = (int)(Math.random() * register.getAvailableCards().size()) + 1;
            register.makeCardActive(cardNumber);
        }
    }
}
