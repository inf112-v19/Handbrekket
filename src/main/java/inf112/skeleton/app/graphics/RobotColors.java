package inf112.skeleton.app.graphics;

import com.badlogic.gdx.graphics.Color;

public enum RobotColors {

    BLACK("assets/robots/black.png"),
    BLUE("assets/robots/blue.png"),
    RED("assets/robots/red.png"),
    GREEN("assets/robots/green.png"),
    YELLOW("assets/robots/yellow.png"),
    ORANGE("assets/robots/orange.png"),
    CYAN("assets/robots/cyan.png"),
    WHITE("assets/robots/white.png");

    private final String string;

    private static RobotColors[] vals = values();

    RobotColors(String string) {
        this.string = string;
    }

    public String getColor() {
        return string;
    }

    public RobotColors next() {
        return vals[(ordinal() + 1) % vals.length];
    }
}