package ladder.domain.ladder;

public enum Direction {

    LEFT, STRAIGHT, RIGHT;

    public static Direction first(DirectionStrategy directionStrategy) {
        if (directionStrategy.move()) {
            return RIGHT;
        }
        return STRAIGHT;
    }

    public Direction next(DirectionStrategy directionStrategy) {
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
