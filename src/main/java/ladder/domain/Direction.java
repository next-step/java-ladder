package ladder.domain;

public enum Direction {
    RIGHT,
    LEFT,
    NONE;

    public boolean right() {
        return this == RIGHT;
    }

    public boolean left() {
        return this == LEFT;
    }
}
