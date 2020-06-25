package nextstep.step4.domain;

public class Direction {
    private boolean left;
    private boolean right;

    private Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction firstPositionDirection(boolean moveable) {
        return new Direction(false, moveable);
    }

    public Direction next(boolean moveable) {
        if (right) {
            return new Direction(true, false);
        }
        return new Direction(false, moveable);
    }

    public Direction last() {
        return new Direction(right, false);
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }
}
