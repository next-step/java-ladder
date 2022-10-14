package ladder.domain.line.v2;

public enum Direction {
    LEFT,
    RIGHT,
    NONE;

    public boolean isRight() {
        return this == RIGHT;
    }

    public boolean isLeft() {
        return this == LEFT;
    }

    public static Direction first(boolean hasRight) {
        if (hasRight) {
            return RIGHT;
        }

        return NONE;
    }

    public Direction next(boolean hasNextRight) {
        if (this == RIGHT) {
            return LEFT;
        }

        if (hasNextRight) {
            return RIGHT;
        }

        return NONE;
    }

    public Direction last() {
        if (this == RIGHT) {
            return LEFT;
        }

        return NONE;
    }
}
