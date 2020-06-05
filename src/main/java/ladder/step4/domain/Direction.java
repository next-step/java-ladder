package ladder.step4.domain;

import java.util.Random;

public enum Direction {
    EMPTY(false, false),
    LEFT(true, false),
    RIGHT(false, true);

    private static final Random RANDOM = new Random();

    private final boolean left;
    private final boolean right;

    Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction createOptional (Direction direction) {
        return RANDOM.nextBoolean() ? direction : EMPTY;
    }

    public static Direction toggle (Direction direction) {
        return direction == Direction.RIGHT ? Direction.LEFT : Direction.RIGHT;
    }
}