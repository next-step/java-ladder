package ladder.domain;

import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction first(boolean right) {
        return new Direction(false, right);
    }

    public Direction next(boolean right) {
        if (this.right && right) {
            return new Direction(true, false);
        }
        return new Direction(this.right, right);
    }

    public Direction last() {
        return new Direction(this.right, false);
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
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
