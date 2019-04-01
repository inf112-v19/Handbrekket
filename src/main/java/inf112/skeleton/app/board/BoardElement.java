package inf112.skeleton.app.board;

import java.util.Arrays;
import java.util.List;

public enum BoardElements {
    FLAG1(null),
    FLAG2(null),
    FLAG3(null),
    FLAG4(null),
    CONVEYORBELT_TURN_LEFT_MOVE_NORTH(Direction.NORTH),
    CONVEYORBELT_TURN_LEFT_MOVE_SOUTH(Direction.SOUTH),
    CONVEYORBELT_TURN_LEFT_MOVE_WEST(Direction.WEST),
    CONVEYORBELT_TURN_LEFT_MOVE_EAST(Direction.EAST),
    CONVEYORBELT_TURN_RIGHT_MOVE_NORTH(Direction.NORTH),
    CONVEYORBELT_TURN_RIGHT_MOVE_SOUTH(Direction.SOUTH),
    CONVEYORBELT_TURN_RIGHT_MOVE_WEST(Direction.WEST),
    CONVEYORBELT_TURN_RIGHT_MOVE_EAST(Direction.EAST),
    CONVEYORBELT_MOVE_NORTH(Direction.NORTH),
    CONVEYORBELT_MOVE_SOUTH(Direction.SOUTH),
    CONVEYORBELT_MOVE_WEST(Direction.WEST),
    CONVEYORBELT_MOVE_EAST(Direction.EAST),
    GEAR_LEFT(null),
    GEAR_RIGHT(null),
    HOLES(null),
    WRENCH(null),
    SPECIAL_WRENCH(null),
    STARTING_POSITION(null),
    WALL_NORTH(Direction.NORTH),
    WALL_EAST(Direction.EAST),
    WALL_SOUTH(Direction.SOUTH),
    WALL_WEST(Direction.WEST);

    private final Direction direction;

    BoardElements(Direction dir) {
        this.direction = dir;
    }

    /**
     * Returns the elements direction, if any
     * @return direction or null if empty
     */
    public Direction getDirection() {
        return direction;
    }

    public static final List<BoardElements> WALLS = Arrays.asList(WALL_NORTH, WALL_EAST, WALL_SOUTH, WALL_WEST);

    /**
     * Contains all normal conveyor belts
     */
    public static final List<BoardElements> CONVEYORBELTS = Arrays.asList(CONVEYORBELT_TURN_LEFT_MOVE_NORTH,
            CONVEYORBELT_TURN_LEFT_MOVE_SOUTH, CONVEYORBELT_TURN_LEFT_MOVE_WEST, CONVEYORBELT_TURN_LEFT_MOVE_EAST,
            CONVEYORBELT_TURN_RIGHT_MOVE_NORTH, CONVEYORBELT_TURN_RIGHT_MOVE_SOUTH, CONVEYORBELT_TURN_RIGHT_MOVE_WEST,
            CONVEYORBELT_TURN_RIGHT_MOVE_EAST, CONVEYORBELT_MOVE_NORTH, CONVEYORBELT_MOVE_SOUTH, CONVEYORBELT_MOVE_WEST,
            CONVEYORBELT_MOVE_EAST);

    /**
     * Contains all conveyor belts that turn counterclockwise
     */
    public static final List<BoardElements> CONVEYORBELTS_TURN_LEFT = Arrays.asList(CONVEYORBELT_TURN_LEFT_MOVE_EAST,
            CONVEYORBELT_TURN_LEFT_MOVE_NORTH, CONVEYORBELT_TURN_LEFT_MOVE_SOUTH, CONVEYORBELT_TURN_LEFT_MOVE_WEST);

    /**
     * Contains all conveyor belts that turn clockwise
     */
    public static final List<BoardElements> CONVEYORBELTS_TURN_RIGHT = Arrays.asList(CONVEYORBELT_TURN_RIGHT_MOVE_EAST,
            CONVEYORBELT_TURN_RIGHT_MOVE_NORTH, CONVEYORBELT_TURN_RIGHT_MOVE_SOUTH, CONVEYORBELT_TURN_RIGHT_MOVE_WEST);

    /**
     * Contains the gears
     */
    public static final List<BoardElements> GEARS = Arrays.asList(GEAR_LEFT, GEAR_RIGHT);
}