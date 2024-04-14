package domain;

public class Bridge {

    private final boolean value;
    private boolean left;
    private boolean current;

    public Bridge() {
        this(false);
    }

    public Bridge(boolean value) {
        this.value = value;
    }

    private Bridge(boolean left, boolean current) {
        this.value = current;
        this.left = left;
        this.current = current;
    }

    public static Bridge first(boolean current) {
        return new Bridge(false, current);
    }

    public Direction move() {
        if (left) {
            return Direction.LEFT;
        }
        if (current) {
            return Direction.RIGHT;
        }
        return Direction.PASS;
    }

    public boolean has() {
        return this.value;
    }
}
