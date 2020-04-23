package ladder.domain;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Direction {
    private static final int NON_CACHE_INDEX = 0;
    private static final int LEFT_CACHE_INDEX = 1;
    private static final int RIGHT_CACHE_INDEX = 2;

    private static final Direction[] DIRECTIONS = new Direction[3];
    private final boolean left;
    private final boolean right;

    static {
        DIRECTIONS[0] = new Direction(FALSE, FALSE);
        DIRECTIONS[1] = new Direction(TRUE, FALSE);
        DIRECTIONS[2] = new Direction(FALSE, TRUE);
    }

    public static Direction of(final boolean left, final boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }
        return DIRECTIONS[getCacheIndex(left, right)];
    }

    private static int getCacheIndex(final boolean left, final boolean right) {
        if (left) {
            return LEFT_CACHE_INDEX;
        }

        if (right) {
            return RIGHT_CACHE_INDEX;
        }

        return NON_CACHE_INDEX;
    }

    public static Direction first(final boolean right) {
        return of(FALSE, right);
    }

    private Direction(final boolean left, final boolean right) {
        this.left = left;
        this.right = right;
    }

    public Direction next(final boolean nextRight) {
        if (this.right) {
            return of(TRUE, FALSE);
        }
        return of(FALSE, nextRight);
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;
        Direction direction = (Direction) o;
        return left == direction.left &&
                right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
