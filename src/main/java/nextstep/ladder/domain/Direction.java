package nextstep.ladder.domain;

import static nextstep.ladder.util.RandomGenerator.generate;

import java.util.Objects;

public class Direction {
    private static final int CALC_INDEX = 2;
    private static final int TRUE_INDEX = 1;
    private static final int FALSE_INDEX = 0;
    private final static Direction[] cache = new Direction[3];
    private final boolean left;
    private final boolean right;

    static {
        cache[0] = new Direction(false, false);
        cache[1] = new Direction(false, true);
        cache[2] = new Direction(true, false);
    }

    public Direction(boolean left, boolean right) {
        validate(left, right);
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
        return next(generate());
    }

    public static Direction of(boolean left, boolean right) {
        validate(left, right);
        return cache[getCacheIndex(left, right)];
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public Direction last() {
        return of(this.right, false);
    }

    private static void validate(final boolean left, final boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
    }

    private static int getCacheIndex(final boolean left, final boolean right) {
        return toInt(left) * CALC_INDEX + toInt(right);
    }

    private static int toInt(final boolean bool) {
        if (bool) {
            return TRUE_INDEX;
        }
        return FALSE_INDEX;
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
