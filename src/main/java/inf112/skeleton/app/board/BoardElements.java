package inf112.skeleton.app.board;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum BoardElements {
    FLAG1(null),
    FLAG2(null),
    FLAG3(null),
    FLAG4(null),
    CONVEYORBELT(null),
    GEAR_LEFT(null),
    GEAR_RIGHT(null),
    HOLES(null),
    WRENCH(null),
    SPECIAL_WRENCH(null),
    STARTING_POSITION(null),
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

    /**
     * Contains all of the pushers
     */
    public static final List<BoardElements> PUSHERS = Arrays.asList(PUSHER_EVEN_NORTH, PUSHER_EVEN_EAST,
            PUSHER_EVEN_SOUTH, PUSHER_EVEN_WEST, PUSHER_ODD_NORTH, PUSHER_ODD_EAST, PUSHER_ODD_SOUTH, PUSHER_ODD_WEST);

    /**
     * Contains all of the pushers that activate on even phases
     */
    public static final List<BoardElements> PUSHERS_EVEN = PUSHERS.subList(0,4);

    /**
     * Contains all of the pushers that activate on odd phases
     */
    public static final List<BoardElements> PUSHERS_ODD = PUSHERS.subList(4,8);

    /**
     * Contains all of the walls
     */
    public static final List<BoardElements> WALLS = Arrays.asList(WALL_NORTH, WALL_EAST, WALL_SOUTH, WALL_WEST);

    /**
     * Contains the gears
     */
    public static final List<BoardElements> GEARS = Arrays.asList(GEAR_LEFT, GEAR_RIGHT);
}
