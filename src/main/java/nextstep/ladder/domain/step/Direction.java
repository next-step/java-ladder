package nextstep.ladder.domain.step;

import nextstep.ladder.domain.step.strategy.Movement;

public class Direction {
    private boolean left;
    private boolean right;

    private Direction(boolean left, boolean right) {
        validDirection(left, right);
        this.left = left;
        this.right = right;
    }

    private void validDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public static Direction left() {
        return new Direction(true, false);
    }

    public static Direction right(Movement movement) {
        return new Direction(false, movement.isMovable());
    }
}
