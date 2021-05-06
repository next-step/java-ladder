package ladder.domain;

public enum Direction {
    RIGHT,
    LEFT,
    NONE;

    public static Direction first(final DirectionDeterminer directionDeterminer) {
        return direction(directionDeterminer);
    }

    public Direction next(final DirectionDeterminer directionDeterminer) {
        if (this == RIGHT) {
            return LEFT;
        }

        return direction(directionDeterminer);
    }

    private static Direction direction(final DirectionDeterminer directionDeterminer) {
        return directionDeterminer.isRight() ? RIGHT : NONE;
    }

    public Direction last() {
        if (this == RIGHT) {
            return LEFT;
        }

        return NONE;
    }
}
