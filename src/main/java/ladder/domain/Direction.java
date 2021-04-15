package ladder.domain;

import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("양쪽 방향을 동시에 가질 수 없습니다.");
        }
        this.left = left;
        this.right = right;
    }

    public boolean hasRightDirection() {
        return right;
    }

    public boolean hasLeftDirection() {
        return left;
    }

    public boolean hasDirection() {
        return left || right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction that = (Direction) o;
        return left == that.left && right == that.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
