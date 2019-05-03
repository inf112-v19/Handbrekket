package inf112.skeleton.app.graphics;

class MessageGFX {
    private String message;
    private int[] position;
    private boolean isVisible;
    private float duration;
    private float scale;

    MessageGFX(String message, int[] position, boolean isVisible, float scale) {
        this(message, position, isVisible, scale, -1);
    }

    MessageGFX(String message, int[] position, boolean isVisible, float scale, float duration) {
        this.message = message;
        this.position = position;
        this.isVisible = isVisible;
        this.scale = scale;
        this.duration = duration;
    }

    boolean hasDuration() {
        return duration != -1;
    }

    /**
     * Decreases the duration by one time-unit and checks if the duration has expired (== 0)
     *
     * @return true if duration = 0, false if != 0
     */
    boolean decreaseDuration() {
        if (!hasDuration())
            return false;

        if (duration < 0) {
            duration = 0;
        } else {
            duration--;
        }
        return duration == 0;
    }

    String getMessage() {
        return message;
    }

    int[] getPosition() {
        return position;
    }

    boolean isVisible() {
        return isVisible;
    }

    void setVisible(boolean visible) {
        isVisible = visible;
    }

    float getDuration() {
        return duration;
    }

    float getScale() {
        return scale;
    }
}
