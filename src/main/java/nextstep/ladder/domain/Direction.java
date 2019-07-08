package nextstep.ladder.domain;

public enum Direction {
    RIGHT,
    LEFT,
    NONE;

    public static Direction first(final boolean isConnected) {
        if (isConnected) {
            return Direction.RIGHT;
        }
        return Direction.NONE;
    }

    public Direction next(final boolean isConnected) {
        if (this == RIGHT) {
            return LEFT;
        }
        if (isConnected) {
            return RIGHT;
        }
        return NONE;
    }

    public Direction last() {
        if (this == RIGHT) {
            return LEFT;
        }
        return Direction.NONE;
    }
}
