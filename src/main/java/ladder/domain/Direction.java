package ladder.domain;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Direction {
    private static final int CURRENT = 0;
    private static final int MOVE_RIGHT = 1;
    private static final int MOVE_LEFT = -1;
    private static final String TRUE_NOT_DUPLICATE = "연속해서 TRUE가 될 수 없습니다.";

    private final boolean left;
    private final boolean right;

    private Direction(final boolean left, final boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(TRUE_NOT_DUPLICATE);
        }

        this.left = left;
        this.right = right;
    }

    public int move() {
        if (this.left) {
            return MOVE_LEFT;
        }
        if (this.right) {
            return MOVE_RIGHT;
        }
        return CURRENT;
    }

    public static Direction of(final boolean first, final boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(final boolean right) {
        return of(FALSE, right);
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    public Direction next(final boolean nextRight) {
        if (this.right) {
            return of(TRUE, FALSE);
        }

        return of(FALSE, nextRight);
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
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
