package domain;

public enum Direction {
    LEFT(true, false),
    RIGHT(false, true),
    DOWN(false, false);

    private final boolean left;
    private final boolean right;

    Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }
}
