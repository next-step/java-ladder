package domain;

public enum Direction {
    LEFT(true, false),
    RIGHT(false, true),
    DOWN(false, false);

    private final boolean left;
    private final boolean right;

    Direction(final boolean left, final boolean right) {
        this.left = left;
        this.right = right;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }
}
