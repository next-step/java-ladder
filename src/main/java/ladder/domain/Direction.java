package ladder.domain;

import java.util.Objects;
import java.util.Random;

import static ladder.domain.Point.generateDirection;

public class Direction {

    protected static final String LADDER_CAN_NOT_BE_CONSECUTIVE = "The ladder cannot be consecutive.";
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        valid(left, right);
        this.left = left;
        this.right = right;
    }


    private void valid(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(LADDER_CAN_NOT_BE_CONSECUTIVE);
        }
    }

    public static Direction first(boolean right) {
        return new Direction(false, right);
    }

    public Direction last() {
        return of(this.right, false);
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public Direction next(boolean left) {
        return of(right, left);
    }

    public Direction next() {
        if (right) {
            return next(false);
        }
        return next(generateDirection());
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
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
