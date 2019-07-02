package ladder.domain;

public enum Direction {

    LEFT(true, false),
    RIGHT(false, true),
    EMPTY(false, false);

    private boolean isLeft;
    private boolean isRight;

    Direction(boolean isLeft, boolean isRight) {

        this.isLeft = isLeft;
        this.isRight = isRight;
    }

    public static Direction of(boolean isLeft, boolean isRight) {

        if (isLeft) {
            return LEFT;
        }

        if (isRight) {
            return RIGHT;
        }

        return EMPTY;
    }

    public static Direction first(boolean isRight) {

        return Direction.of(false, isRight);
    }

    public static Direction middle(Direction before, boolean isRight) {

        if (before.isRight) {
            return LEFT;
        }

        if (before.isLeft) {
            return EMPTY;
        }

        return Direction.of(false, isRight);
    }

    public static Direction last(Direction before) {

        if (before.isRight) {
            return LEFT;
        }

        return Direction.EMPTY;
    }
}
