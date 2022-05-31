package ladder.constant;

public enum Direction {

    LEFT(-1),
    RIGHT(1),
    STAY(0);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public boolean isLeft() {
        return this == LEFT;
    }

    public boolean isRight() {
        return this == RIGHT;
    }
}
