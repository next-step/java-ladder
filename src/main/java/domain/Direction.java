package domain;

import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    private Direction next(boolean next) {
        return Direction.of(this.right, next);
    }

    public Direction next(LadderLevel ladderLevel) {
        if (this.right) {
            return next(Boolean.FALSE);
        }
        return next(ladderLevel.random());
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public Direction last() {
        return of(this.right, false);
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
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
