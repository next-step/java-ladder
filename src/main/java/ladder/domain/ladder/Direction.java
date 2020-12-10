package ladder.domain.ladder;

import ladder.context.ErrorMessage;

import java.util.Objects;

public class Direction {
    public static final int MOVE_LEFT = -1;
    public static final int MOVE_RIGHT = 1;
    public static final int MOVE_CENTER = 0;

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(ErrorMessage.DIRECTION_VALID.getMessage());
        }
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        if (left && right) {
            return new Direction(true, false);
        }
        return new Direction(left, right);
    }

    public int move() {
        if (left) {
            return MOVE_LEFT;
        }
        if (right) {
            return MOVE_RIGHT;
        }
        return MOVE_CENTER;
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
