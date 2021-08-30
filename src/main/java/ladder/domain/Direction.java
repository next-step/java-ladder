package ladder.domain;

import static java.lang.Boolean.*;

import java.util.Objects;

import ladder.strategy.MovableStrategy;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }

    private static boolean generatePoint(MovableStrategy movableStrategy) {
        return movableStrategy.isMovable();
    }

    private void validate(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public Direction next(boolean nextRight) {
        return of(right, nextRight);
    }

    public Direction next(MovableStrategy movableStrategy) {
        if (right) {
            return next(FALSE);
        }
        return next(generatePoint(movableStrategy));
    }

    public Direction last() {
        return of(right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Direction pair = (Direction)o;
        return left == pair.left &&
            right == pair.right;
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
