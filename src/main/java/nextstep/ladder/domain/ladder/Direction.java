package nextstep.ladder.domain.ladder;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static nextstep.ladder.domain.ladder.LadderPointGenerator.generatePoint;

class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
    }

    boolean isRight() {
        return this.right;
    }

    boolean isLeft() {
        return this.left;
    }

    Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    Direction next() {
        if (this.right) {
            return next(FALSE);
        }
        return next(generatePoint());
    }

    static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    static Direction first(boolean right) {
        return of(FALSE, right);
    }

    Direction last() {
        return of(this.right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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

