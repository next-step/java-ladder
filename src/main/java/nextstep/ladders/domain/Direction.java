package nextstep.ladders.domain;

import java.util.Objects;

public class Direction {

    private final boolean left;
    private final boolean right;

    private Direction(final boolean left, final boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.right = right;
    }

    public static Direction first(final boolean next) {
        return new Direction(false, next);
    }

    public static Direction of(final boolean left, final boolean right) {
        return new Direction(left, right);
    }

    public Direction next(final boolean next) {
        if (this.right) {
            return Direction.of(true, false);
        }
        return Direction.of(false, next);
    }

    public Direction last() {
        return Direction.of(this.right, false);
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
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
