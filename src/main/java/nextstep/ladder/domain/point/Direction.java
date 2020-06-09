package nextstep.ladder.domain.point;

import java.util.Objects;

public class Direction {

    private final boolean left;
    private final boolean right;

    Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
    }

    public static Direction first(PointGenerator pointGenerator) {
        return new Direction(false, pointGenerator.isRight());
    }

    public Direction last() {
        return new Direction(this.right, false);
    }

    public Direction next(PointGenerator pointGenerator) {
        if (this.right) {
            return new Direction(true, false);
        }
        return new Direction(false, pointGenerator.isRight());
    }

    public boolean isValid(Direction pre) {
        return !(pre.right && this.right);
    }

    boolean isRight() {
        return this.right;
    }

    boolean isLeft() {
        return this.left;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Direction direction = (Direction) o;
        return left == direction.left &&
            right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
