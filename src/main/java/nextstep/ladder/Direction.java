package nextstep.ladder;

import java.util.Objects;
import java.util.Random;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(); //todo: 예외 정의
        }
        this.left = left;
        this.right = right;
    }

    public static Direction first(boolean right) {
        return new Direction(false, right);
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public Direction next(boolean right) {
        return new Direction(this.right, right);
    }

    public Direction next() {
        if (this.right) {
            return next(false);
        }
        return next(new Random().nextBoolean());
    }

    public Direction last() {
        return of(this.right, false);
    }

    public int move() {
        if (this.right) {
            return 1;
        }

        if (this.left) {
            return -1;
        }
        return 0;
    }

    public boolean isRight() {
        return right;
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
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
