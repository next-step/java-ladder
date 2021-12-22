package nextstep.ladder.model;

public enum PointDirection {
    LEFT,
    RIGHT,
    NONE;

    private static final RandomGenerator RANDOM_GENERATOR = new RandomGenerator();

    public static PointDirection first(boolean right) {
        if (right) {
            return RIGHT;
        }
        return NONE;
    }

    public PointDirection last() {
        if (this == RIGHT) {
            return LEFT;
        }
        return NONE;
    }

    public PointDirection next() {
        if (this == RIGHT) {
            return LEFT;
        }
        return nextNotHaveLeft(RANDOM_GENERATOR.trueOrFalse());
    }

    private PointDirection nextNotHaveLeft(boolean nextRight) {
        if (nextRight) {
            return RIGHT;
        }
        return NONE;
    }
}
