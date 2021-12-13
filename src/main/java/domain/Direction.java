package domain;

import java.util.Objects;

import static domain.RandomGenerator.generatePoint;
import static java.lang.Boolean.FALSE;

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

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next() {
        if (this.right) {
            return next(FALSE);
        }

        return next(generatePoint());
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Direction direction = (Direction) object;

        return left == direction.left &&
                right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
