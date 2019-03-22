package inf112.skeleton.app.game;

public enum GameRuleConstans {
    MAX_LIVES(3), MAX_DAMAGE(9), MAX_CARDS_IN_REGISTER(9), ACTIVE_CARDS_IN_REGISTER(5);

    GameRuleConstans (int value){
        this.value=value;
    }

    private final int value;

    public int getValue () {
        return value;
    }
}
