package inf112.skeleton.app.board;

public class MovementBoardElement implements IMovementBoardElement{
    /**
     * Return coordinates as a Array with X as the first value and Y as the second value
     *
     * @return
     */
    @Override
    public int[] getCoordinates() {
        return new int[0];
    }

    /**
     * Return the direction conveyor belt
     *
     * @return
     */
    @Override
    public Direction getDirection() {
        return null;
    }

    /**
     * Returns movement value
     *
     * @return
     */
    @Override
    public int[] getMoveValue() {
        return new int[0];
    }

    /**
     * Returns the direction to rotate
     * True if rotate clockwise , False if rotate counter clockwise
     *
     * @return
     */
    @Override
    public boolean getRotationDirection() {
        return false;
    }
}
