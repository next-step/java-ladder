package nextstep.ladder.model;

import nextstep.ladder.exception.TwoWayDirectionException;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static nextstep.ladder.util.LadderPointGenerator.generatePoint;

public class Direction {

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new TwoWayDirectionException();
        }

        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(Boolean right) {
        return of(FALSE, right);
    }

    public Direction next() {
        if (this.right) {
            return next(FALSE);
        }
        return next(generatePoint());
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction last() {
        return of(this.right, FALSE);
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
