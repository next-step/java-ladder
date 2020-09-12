package ladder.model;

import java.util.Objects;

public class Direction {

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        validateDirection(left, right);
        this.left = left;
        this.right = right;
    }

    public void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("방향은 왼쪽, 오른쪽 중 하나만 가질 수 있습니다.");
        }
    }

    public int move() {
        if (left) {
            return -1;
        }

        if (right) {
            return 1;
        }

        return 0;
    }

    public Direction next(boolean generateRight) {
        if (this.right) {
            return new Direction(true, false);
        }
        return new Direction(false, generateRight);
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
