package step3_renewal.domain;

import java.util.Objects;

public class Direction {

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }
        this.left = left;
        this.right = right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public Direction next(boolean nextRight) {
        if (this.right) {
            return of(this.right, false);
        }
        return of(this.right, nextRight);
    }

    public static Direction first(boolean direction) {
        return new Direction(false, direction);
    }

    public Direction last() {
        return of(this.right, false);
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
