package nextstep.ladder.model;

import java.util.function.UnaryOperator;

public enum PointDirection {
    LEFT(x -> x - 1),
    RIGHT(x -> x + 1),
    NONE(x -> x);

    private static final RandomGenerator RANDOM_GENERATOR = new RandomGenerator();

    private final UnaryOperator<Integer> policy;

    PointDirection(UnaryOperator<Integer> policy) {
        this.policy = policy;
    }

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

    public int move(int position) {
        return policy.apply(position);
    }

    private PointDirection nextNotHaveLeft(boolean nextRight) {
        if (nextRight) {
            return RIGHT;
        }
        return NONE;
    }
}
