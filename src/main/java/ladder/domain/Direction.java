package ladder.domain;

public enum Direction {
    STRAIGHT(0), LEFT(-1), RIGHT(1);

    private final int unitDirection;

    Direction(int unitDirection) {
        this.unitDirection = unitDirection;
    }

    public int nextPosition(int position) {
        return this.unitDirection + position;
    }

    static Direction rightOrStraight(boolean isRight) {
        if (isRight) {
            return RIGHT;
        }
        return STRAIGHT;
    }

    public Direction next(boolean isRight) {
        if (this.equals(RIGHT)) {
            return LEFT;
        }
        return rightOrStraight(isRight);
    }

    public Direction last() {
        if (this.equals(RIGHT)) {
            return LEFT;
        }
        return STRAIGHT;
    }
}
