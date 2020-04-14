package nextstep.ladder.domain;

import java.util.Objects;
import java.util.Random;

public class Direction {
    private static final Direction TRUE_FALSE = new Direction(true, false);
    private static final Direction FALSE_TRUE = new Direction(false, true);
    private static final Direction FALSE_FALSE = new Direction(false, false);
    private Random random = new Random();

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.right = right;
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next() {
        if (this.right) {
            return next(false);
        }
        return next(generatePoint());
    }

    public static Direction of(boolean first, boolean second) {
        if (first && !second) {
            return TRUE_FALSE;
        }
        if (!first && second) {
            return FALSE_TRUE;
        }
        if (!first && !second) {
            return FALSE_FALSE;
        }

        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public Direction last() {
        return of(this.right, false);
    }

    private boolean generatePoint() {
        return random.nextBoolean();
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Direction)) { return false; }
        final Direction direction = (Direction) o;
        return left == direction.left &&
               right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "Direction{" +
               "left=" + left +
               ", right=" + right +
               '}';
    }
}
