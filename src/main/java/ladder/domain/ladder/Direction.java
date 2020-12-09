package ladder.domain.ladder;

import java.util.Objects;

public class Direction {
    public static final int MOVE_LEFT = -1;
    public static final int MOVE_RIGHT = 1;
    public static final int MOVE_CENTER = 0;

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("유효하지 않은 값 입니다.");
        }
        this.left = left;
        this.right = right;
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
