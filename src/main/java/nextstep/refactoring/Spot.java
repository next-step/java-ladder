package nextstep.refactoring;

import java.util.Objects;

/**
 * 이동가능한 방향에 대한 상태값을 가짐
 * 1. 현재 상태에 따라 다음 이동 방향을 결정할 수 있음 (move())
 */
public class Spot {
    private final boolean left;
    private final boolean right;

    public Spot(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("올바르지 않은 상태값입니다.");
        }
        this.left = left;
        this.right = right;
    }

    public static Spot first(boolean state) {
        return new Spot(false, state);
    }

    public Spot right(boolean state) {
        return new Spot(this.left, state);
    }

    public Spot last() {
        return new Spot(this.right, false);
    }

    public Direction move() {
        if (right) {
            return Direction.RIGHT;
        }

        if (left) {
            return Direction.LEFT;
        }
        return Direction.PASS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spot spot = (Spot) o;
        return left == spot.left && right == spot.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
