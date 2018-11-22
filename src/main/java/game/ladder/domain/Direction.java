package game.ladder.domain;

import com.google.common.base.Preconditions;

public class Direction {

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        Preconditions.checkState(isNotAllTrue(left, right), "왼쪽과 오른쪽 모두 true 일 수 없습니다.");
        this.left = left;
        this.right = right;
    }

    private boolean isNotAllTrue(boolean left, boolean right) {
        return !(left && right);
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public Direction next() {
        if (this.right) {
            return next(false);
        }
        return next(LadderPointGenerator.generatePoint());
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    public Direction last() {
        return new Direction(this.right, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction = (Direction) o;

        if (left != direction.left) return false;
        return right == direction.right;
    }

    @Override
    public int hashCode() {
        int result = (left ? 1 : 0);
        result = 31 * result + (right ? 1 : 0);
        return result;
    }
}
