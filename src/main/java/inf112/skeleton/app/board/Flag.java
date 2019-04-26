package inf112.skeleton.app.board;

public class Flag implements IFlag{

    private int flagId;
    private int[] coordinates;

    @Override
    public int[] getPosition() {
        return coordinates;
    }

    @Override
    public int getFlagId{
        return flagId;
    }


}
