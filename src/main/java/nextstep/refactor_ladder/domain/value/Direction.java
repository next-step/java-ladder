package nextstep.refactor_ladder.domain.value;

import nextstep.refactor_ladder.strategy.PointStrategy;

import java.util.Objects;

public class Direction {

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        validateDirection(left, right);
        this.left = left;
        this.right = right;
    }

    public static Direction first(boolean right) {
        return new Direction(false, right);
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public Direction next(PointStrategy pointStrategy) {
        if (prevRight()) {
            return next(false);
        }
        return next(pointStrategy.createPoint());
    }

    public Direction last() {
        return of(prevRight(), false);
    }

    private Direction next(boolean right) {
        return of(prevRight(), right);
    }

    private boolean prevRight() {
        return right;
    }

    private void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("가로 라인이 연속해서 겹칠 수 없습니다.");
        }
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
