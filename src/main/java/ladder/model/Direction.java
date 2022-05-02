package ladder.model;

import ladder.exception.InvalidDirectionException;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    HOLD(0);

    private final int moveCount;

    Direction(int moveCount) {
        this.moveCount = moveCount;
    }

    public static Direction of(boolean isLeft, boolean isRight) {
        if (isLeft && isRight) {
            throw new InvalidDirectionException();
        }

        if (isLeft) {
            return LEFT;
        }

        if (isRight) {
            return RIGHT;
        }

        return HOLD;
    }

    public int move(int index) {
        return this.moveCount + index;
    }

    public boolean isRight() {
        return this == RIGHT;
    }

    public boolean isLeft() {
        return this == LEFT;
    }

}
