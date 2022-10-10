package nextstep.ladder.domain;

import java.util.Objects;

public class Movement {

    private final boolean left;
    private final boolean right;

    private Movement(final boolean left, final boolean right) {

        validate(left, right);
        this.left = left;
        this.right = right;
    }

    public static Movement first(final boolean right) {

        return new Movement(false, right);
    }

    private void validate(final boolean left, final boolean right) {

        if (left && right) {
            throw new IllegalArgumentException("이동할 수 없습니다.");
        }
    }

    public Direction move() {

        if (this.right) {
            return Direction.RIGHT;
        }
        if (this.left) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    public Movement next(final boolean right) {

        if (this.right && right) {
            return new Movement(this.right, false);
        }
        return new Movement(this.right, right);
    }

    public boolean isRight() {

        return right;
    }

    public boolean isLeft() {

        return left;
    }

    public boolean duplicate() {

        return this.isLeft() && this.isRight();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movement movement = (Movement) o;
        return left == movement.left && right == movement.right;
    }

    @Override
    public int hashCode() {

        return Objects.hash(left, right);
    }
}
