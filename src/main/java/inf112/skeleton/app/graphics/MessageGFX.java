package inf112.skeleton.app.graphics;

public class MessageGFX {
    private String message;
    private int[] position;
    private boolean isVisible;
    private int duration;

    public MessageGFX(String message, int[] position, boolean isVisible) {
        this(message, position, isVisible, -1);
    }

    public MessageGFX(String message, int[] position, boolean isVisible, int duration) {
        this.message = message;
        this.position = position;
        this.isVisible = isVisible;
        this.duration = duration;
    }

    public boolean hasDuration() {
        return duration != -1;
    }

    /**
     * Decreases the duration by one time-unit and checks if the duration has expired (== 0)
     * @return true if duration = 0, false if != 0
     */
    public boolean decreaseDuration() {
        if(duration > 0);
            duration -= 1;
        return duration == 0;
    }

    public String getMessage() {
        return message;
    }

    public int[] getPosition() {
        return position;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public int getDuration() {
        return duration;
    }
}
