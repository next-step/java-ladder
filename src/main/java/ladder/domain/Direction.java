package ladder.domain;

import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

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

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public boolean isRight() {
        return this.right;
    }

    public Direction next() {
        if (this.right) {
            return next(false);
        }
        return next(new Random().nextBoolean());
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction last() {
        return of(this.right, false);
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

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
