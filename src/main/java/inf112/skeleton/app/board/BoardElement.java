package inf112.skeleton.app.board;

import java.util.Arrays;
import java.util.List;

public enum BoardElement {
    FLAG1(null),
    FLAG2(null),
    FLAG3(null),
    FLAG4(null),
    CONVEYORBELT(null),
    GEAR_LEFT(null),
    GEAR_RIGHT(null),
    HOLE(null),
    WRENCH(null),
    SPECIAL_WRENCH(null),
    STARTING_POSITION_1(null),
    STARTING_POSITION_2(null),
    STARTING_POSITION_3(null),
    STARTING_POSITION_4(null),
    STARTING_POSITION_5(null),
    STARTING_POSITION_6(null),
    STARTING_POSITION_7(null),
    STARTING_POSITION_8(null),
    PUSHER_EVEN_NORTH(Direction.NORTH),
    PUSHER_EVEN_EAST(Direction.EAST),
    PUSHER_EVEN_SOUTH(Direction.SOUTH),
    PUSHER_EVEN_WEST(Direction.WEST),
    PUSHER_ODD_NORTH(Direction.NORTH),
    PUSHER_ODD_EAST(Direction.EAST),
    PUSHER_ODD_SOUTH(Direction.SOUTH),
    PUSHER_ODD_WEST(Direction.WEST),
    WALL_NORTH(Direction.NORTH),
    WALL_EAST(Direction.EAST),
    WALL_SOUTH(Direction.SOUTH),
    WALL_WEST(Direction.WEST);

    private final Direction direction;

    BoardElement(Direction dir) {
        this.direction = dir;
    }

    /**
     * Returns the elements direction, if any
     * @return direction or null if empty
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Contains the wrenches
     */
    public static final List<BoardElement> WRENCHES = Arrays.asList(WRENCH, SPECIAL_WRENCH);

    /**
     * Contains all of the flags
     */
    public static final List<BoardElement> FLAGS = Arrays.asList(FLAG1, FLAG2, FLAG3, FLAG4);

    /**
     * Contains all of the starting points
     */
    public static final List<BoardElement> STARTING_POINTS = Arrays.asList(STARTING_POSITION_1, STARTING_POSITION_2,
            STARTING_POSITION_3, STARTING_POSITION_4, STARTING_POSITION_5, STARTING_POSITION_6, STARTING_POSITION_7,
            STARTING_POSITION_8);

    /**
     * Contains all of the pushers
     */
    public static final List<BoardElement> PUSHERS = Arrays.asList(PUSHER_EVEN_NORTH, PUSHER_EVEN_EAST,
            PUSHER_EVEN_SOUTH, PUSHER_EVEN_WEST, PUSHER_ODD_NORTH, PUSHER_ODD_EAST, PUSHER_ODD_SOUTH, PUSHER_ODD_WEST);

    /**
     * Contains all of the pushers that activate on even phases
     */
    public static final List<BoardElement> PUSHERS_EVEN = PUSHERS.subList(0,4);

    /**
     * Contains all of the pushers that activate on odd phases
     */
    public static final List<BoardElement> PUSHERS_ODD = PUSHERS.subList(4,8);

    /**
     * Contains all of the walls
     */
    public static final List<BoardElement> WALLS = Arrays.asList(WALL_NORTH, WALL_EAST, WALL_SOUTH, WALL_WEST);

    /**
     * Contains the gears
     */
    public static final List<BoardElement> GEARS = Arrays.asList(GEAR_LEFT, GEAR_RIGHT);
}
