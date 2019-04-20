package domain;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
    }

    public static Direction generate(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public boolean isLeftMovable() {
        return this.left;
    }

    public boolean isRightMovable() {
        return this.right;
    }

}
