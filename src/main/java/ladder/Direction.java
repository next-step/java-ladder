package ladder;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Direction {
    private final boolean left;
    private final boolean right;

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(Boolean right) {
        return of(FALSE, right);
    }

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }
        this.left = left;
        this.right = right;
    }

    public Direction next(boolean nextRight) {
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
