package ladderrefactoring.domain.ladder;

import ladderrefactoring.exception.CustomException;

import java.util.Objects;

public class Direction {

    public static final String EXIST_TRUE_REPETITION = "연속된 사다리가 존재 합니다.";

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        checkTrueRepetition(left, right);
        this.left = left;
        this.right = right;
    }

    public static Direction first(boolean right) {
        return new Direction(false, right);
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction of(Direction directionBefore, boolean right) {
        return new Direction(directionBefore.right, right);
    }

    public static Direction last(Direction directionBefore) {
        return new Direction(directionBefore.right, false);
    }

    private void checkTrueRepetition(boolean beforeValue, boolean currentValue) {
        if (beforeValue && currentValue) {
            throw new CustomException(EXIST_TRUE_REPETITION);
        }
    }

    public boolean left() {
        return left;
    }

    public boolean right() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
