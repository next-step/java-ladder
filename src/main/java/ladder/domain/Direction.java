package ladder.domain;

public class Direction {
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction getFirst(boolean right) {
        return new Direction(false, right);
    }

    public static Direction getLast(boolean left) {
        return new Direction(left, false);
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    public Direction next(boolean right) {
        if (isRight()) {
            return new Direction(isRight(), false);
        }
        return new Direction(false, right);
    }
}
