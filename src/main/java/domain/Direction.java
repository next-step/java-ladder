package domain;

import util.RandomUtil;

import java.util.Objects;

public class Direction {

    private final boolean left;
    private final boolean right;

    private Direction(final boolean left, final boolean right) {

        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next() {
        if (this.right) {
            return next(false);
        }
        return next(RandomUtil.generate());
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public Direction last() {
        return of(this.right, false);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
        final StringBuilder sb = new StringBuilder("Direction{");
        sb.append("left=").append(left);
        sb.append(", right=").append(right);
        sb.append('}');
        return sb.toString();
    }

}
