package domain;

public enum Direction {
    LEFT, RIGHT, NONE;

    public boolean isLeft() {
        return this == LEFT;
    }

    public boolean isRight() {
        return this == RIGHT;
    }

    public static Direction first(boolean canMake) {
        if (canMake) {
            return RIGHT;
        }

        return NONE;
    }

    public Direction next(boolean canMake) {
        if (isRight()) {
            return LEFT;
        }

        if (canMake) {
            return RIGHT;
        }

        return NONE;
    }

    public Direction last() {
        if (isRight()) {
            return LEFT;
        }
        return NONE;
    }
}
