package nextstep.ladder.domain.point;

import nextstep.ladder.domain.rule.WayRule;

import java.util.Objects;

import static nextstep.ladder.utils.Validation.checkNotNull;

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
            throw new BothWayException();
        }
    }

    public static Direction first(boolean right) {
        return new Direction(BOTH_ENDS, right);
    }

    public Direction next(WayRule wayRule) {
        checkNotNull(wayRule);
        return next(wayRule.canCreate());
    }

    private Direction next(boolean nextRight) {
        if (right) {
            return new Direction(true, false);
        }
        return new Direction(false, nextRight);
    }

    public Direction last() {
        return new Direction(right, BOTH_ENDS);
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
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
