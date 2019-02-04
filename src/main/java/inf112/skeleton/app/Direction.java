package inf112.skeleton.app;

/**
 * Short and simple implementation of a Direction Enum
 * Uses the four cardinal directions as a base,
 * North, west, south, east
 */
public enum Direction {
    NORTH ("N"),
    WEST ("W"),
    SOUTH ("S"),
    EAST ("E");

    private final String symbol;

    Direction(String code) {
        this.symbol = code;
    }

    /**
     * Returns the shorter symbol associated with the direction
     * @return symbol
     */
    public String getSymbol() {
        return symbol;
    }
}
