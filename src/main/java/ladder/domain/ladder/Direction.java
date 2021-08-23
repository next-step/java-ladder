package ladder.domain.ladder;

public enum Direction {

    LEFT, STRAIGHT, RIGHT;

    public static Direction ofFirst(final DirectionStrategy directionStrategy) {
        if (directionStrategy.move()) {
            return RIGHT;
        }
        return STRAIGHT;
    }

    public Direction ofNext(final DirectionStrategy directionStrategy) {
        if (this == RIGHT) {
            return LEFT;
        }
        if (directionStrategy.move()) {
            return RIGHT;
        }
        return STRAIGHT;
    }

    public Direction ofLast() {
        if(this == RIGHT) {
            return LEFT;
        }
        return STRAIGHT;
    }
}
