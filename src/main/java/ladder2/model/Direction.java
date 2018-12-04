package ladder2.model;

import java.util.Objects;

import static ladder2.LadderPointGenerator.generatePoint;

public class Direction {
    private static final Direction LEFT_DIRECTION = new Direction(true, false);
    private static final Direction RIGHT_DIRECTION = new Direction(false, true);
    private static final Direction BOTTOM_DIRECTION = new Direction(false, false);

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }

        this.left = left;
        this.right = right;
    }

    public static Direction from(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }

        if (left && !right) {
            return LEFT_DIRECTION;
        }

        if (!left && right) {
            return RIGHT_DIRECTION;
        }

        return BOTTOM_DIRECTION;
    }

    public static Direction first(boolean right) {
        return from(false, right);
    }

    public Direction last() {
        return from(this.right, false);
    }

    public Direction next(boolean nextRight) {
        return from(this.right, nextRight);
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction next() {
        if (this.right) {
            return next(false);
        }

        return next(generatePoint());
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
