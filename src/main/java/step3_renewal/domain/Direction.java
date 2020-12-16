package step3_renewal.domain;

import java.util.Objects;

public class Direction {

    private static final boolean FALSE = false;

    private final boolean left;
    
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(boolean right) {
        return new Direction(FALSE, right);
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    public Direction next(boolean nextRight) {
        if (this.right) {
            return of(this.right, FALSE);
        }
        return of(this.right, nextRight);
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left &&
                right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
