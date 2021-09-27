package nextstep.ladder.model.v2;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Direction {
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return this.right;
    }

    public Direction next(LadderPointGenerator generator) {
        if (this.right) {
            return next(FALSE);
        }
        return next(generator.generatePoint());
    }

    public Direction next(Boolean right) {
        return of(this.right, right);
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(Boolean right) {
        return of(FALSE, right);
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
