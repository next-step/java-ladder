package domain;

public class Direction {
    private boolean left;
    private boolean right;

    private Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction first(boolean movable) {
        return new Direction(Boolean.FALSE, movable);
    }

    public Direction next(boolean movable) {
        if(right && movable) {
            return new Direction(right, false);
        }

        return new Direction(right, movable);
    }

    public Direction last() {
        return new Direction(right, Boolean.FALSE);
    }

    public boolean leftMovable() {
        return left;
    }

    public boolean rightMovable() {
        return right;
    }
}
