package game.ladder.domain;

import com.google.common.base.Preconditions;

public enum Direction {

    LEFT(true, false), PASS(false, false), RIGHT(false, true);

    private final boolean left;
    private final boolean right;

    Direction(boolean left, boolean right) {
        Preconditions.checkState(isNotAllTrue(left, right), "왼쪽과 오른쪽 모두 true 일 수 없습니다.");
        this.left = left;
        this.right = right;
    }

    private boolean isNotAllTrue(boolean left, boolean right) {
        return !(left && right);
    }

    public static Direction of(boolean left, boolean right) {
        for (Direction direction : values()) {
            if (direction.isSameAs(left, right)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 방향 입니다.");
    }

    private boolean isSameAs(boolean left, boolean right) {
        return this.left == left && this.right == right;
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
        return Direction.of(this.right, false);
    }

}
