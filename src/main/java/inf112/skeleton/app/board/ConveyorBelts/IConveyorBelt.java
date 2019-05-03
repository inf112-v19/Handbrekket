package inf112.skeleton.app.board.ConveyorBelts;

import inf112.skeleton.app.util.Direction;

public interface IConveyorBelt {
    /**
     * Gets the current direction stored in the object
     * @return Direction
     */
    Direction getDirection();

    /**
     * Checks if the conveyorbelt is of the express type
     * @return true if express type, false otherwise
     */
    boolean isExpressType();

    /**
     * Returns the coordinates of the conveyorbelt as an int[] array
     * @return position
     */
    int[] getPosition();
}
