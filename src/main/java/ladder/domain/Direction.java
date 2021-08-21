package ladder.domain;

public enum Direction {
    RIGHT,
    LEFT,
    NONE;

    public Direction next(Direction direction) {
        if (isRight()) {
            return LEFT;
        }
        return direction;
    }

    public Direction last() {
        if (isRight()) {
            return LEFT;
        }
        return Direction.NONE;
    }

    public boolean isRight() {
        return this == RIGHT;
    }

    public boolean isLeft() {
        return this == LEFT;
    }
}
