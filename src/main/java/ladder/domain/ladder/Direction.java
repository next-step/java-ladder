package ladder.domain.ladder;

public enum Direction {

    LEFT(-1), STRAIGHT(0), RIGHT(1);

    private final int distance;

    Direction(final int distance) {
        this.distance = distance;
    }

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
        if (this == RIGHT) {
            return LEFT;
        }
        return STRAIGHT;
    }

    public int move() {
        return distance;
    }
}
