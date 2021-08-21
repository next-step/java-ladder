package ladder.domain.ladder;

public enum Direction {

    LEFT, STRAIGHT, RIGHT;

    public static Direction first(final DirectionStrategy directionStrategy) {
        if (directionStrategy.move()) {
            return RIGHT;
        }
        return STRAIGHT;
    }

    public Direction next(final DirectionStrategy directionStrategy) {
        if (this == RIGHT) {
            return LEFT;
        }
        if (directionStrategy.move()) {
            return RIGHT;
        }
        return STRAIGHT;
    }

    public Direction last() {
        if(this == RIGHT) {
            return LEFT;
        }
        return STRAIGHT;
    }
}
