package nextstep.ladder;

import java.util.Objects;

public class Direction {

    private static final boolean BOTH_ENDS = false;

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        checkSingleWay(left, right);
        this.left = left;
        this.right = right;
    }

    private void checkSingleWay(boolean left, boolean right) {
        if (left && right) {
            throw new BothWayDirectionException();
        }
    }

    public static Direction first(boolean right) {
        return new Direction(BOTH_ENDS, right);
    }

    public static Direction last(boolean left) {
        return new Direction( left, BOTH_ENDS);
    }

    public Direction next(boolean nextRight) {
        return new Direction(this.right, nextRight);
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
