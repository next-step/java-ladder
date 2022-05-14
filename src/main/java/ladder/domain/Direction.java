package ladder.domain;

public enum Direction {
    STRAIGHT, LEFT, RIGHT;

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
