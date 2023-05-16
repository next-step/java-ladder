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

    private void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("사다리 한 위치에 가로 라인이 겹칠 수 없습니다.");
        }
    }

    public static Direction createFirst(boolean right) {
        return new Direction(false, right);
    }

    public Direction createNext(boolean right) {
        if (this.right) {
            return new Direction(true, false);
        }
        return new Direction(false, right);
    }

    public Direction createLast() {
        return new Direction(this.right, false);
    }

    public boolean hasRight() {
        return this.right;
    }

    public boolean hasLeft() {
        return this.left;
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
