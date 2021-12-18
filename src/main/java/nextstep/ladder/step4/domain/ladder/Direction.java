package nextstep.ladder.step4.domain.ladder;

import static java.lang.Boolean.FALSE;

import java.util.Objects;

public class Direction {

    private static final boolean DEFAULT_VALUE = FALSE;

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        valid(left, right);
        this.left = left;
        this.right = right;
    }

    public static Direction first(boolean right) {
        return new Direction(DEFAULT_VALUE, right);
    }

    public Direction next(boolean right) {
        if (this.right) {
            right = false;
        }

        return new Direction(this.right, right);
    }

    public Direction last() {
        return new Direction(this.right, DEFAULT_VALUE);
    }

    public boolean right() {
        return right;
    }

    private void valid(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("올바르지 않은 사다리를 생성하려 하였습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

}
