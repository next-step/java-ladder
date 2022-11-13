package nextstep.ladder.domain;

import java.util.Objects;

public class Direction {

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    private void validate(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("이동이 불가능합니다.");
        }
    }

    public static Direction first(boolean right) {
        return new Direction(false, right);
    }

    public Direction last() {
        return new Direction(right, false);
    }

    public Direction next(boolean direction) {
        if (right) {
            return new Direction(true, false);
        }
        return new Direction(false, direction);
    }

    public boolean isRight() {
        return right;
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
