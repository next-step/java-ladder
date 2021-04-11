package nextstep.refactoring.ladder;

import java.util.Objects;
import java.util.Random;

public class Direction {

    private static final Random RANDOM = new Random();

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        validate(left, right);
        return new Direction(left, right);
    }

    private static void validate(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
    }

    public static Direction straight() {
        return Direction.of(false, false);
    }

    public static Direction left() {
        return Direction.of(true, false);
    }

    public static Direction right() {
        return Direction.of(false, true);
    }

    public Direction next() {
        return right ? Direction.left() : next(RANDOM.nextBoolean());
    }

    public Direction next(boolean isTurnRight) {
        return isTurnRight ? Direction.right() : Direction.straight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
