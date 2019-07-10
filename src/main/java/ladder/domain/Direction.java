package ladder.domain;

import java.util.Random;

public enum Direction {
    RIGHT(false, true),
    LEFT(true, false),
    PASS(false, false);

    private static final Random random = new Random();
    private boolean left;
    private boolean right;

    Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction first(boolean right) {
        return right ? Direction.RIGHT : Direction.PASS;
    }

    public static Direction first() {
        return random.nextBoolean() ? Direction.RIGHT : Direction.PASS;
    }

    public Direction next() {
        return this == Direction.RIGHT ? Direction.LEFT : first();
    }

    public Direction last() {
        return this == Direction.RIGHT ? Direction.LEFT : Direction.PASS;
    }

    public Position move(Position position) {
        return this == Direction.PASS ? position : checkDirection(position);
    }

    private Position checkDirection(Position position) {
        return this == Direction.RIGHT ? position.increase() : position.decrease();
    }
}
