package ladder.domain;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static ladder.domain.PointGenerator.generatePoint;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
        System.out.println(this);
    }

    static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    static Direction first(boolean right) {
        return of(FALSE, right);
    }

    boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    Direction next(boolean nextRight) {
        return of(right, nextRight);
    }

    Direction next() {
        if (right) {
            return next(FALSE);
        }
        return next(generatePoint());
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
        Direction pair = (Direction) o;
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
