package ladder.domain;

public enum Direction {
    LEFT(true, false, -1),
    RIGHT(false, true, 1),
    PASS(false, false, 0);

    private final boolean left;
    private final boolean right;
    private final int move;

    Direction(boolean left, boolean right, int move) {
        this.left = left;
        this.right = right;
        this.move = move;
    }

    public static Direction of(boolean left, boolean right) {
        if (left) {
            return LEFT;
        }
        if (right) {
            return RIGHT;
        }
        return PASS;
    }

    public static Direction first(boolean right) {
        return Direction.of(false, right);
    }

    public static Direction end(boolean left) {
        return Direction.of(left, false);
    }

    public Direction next(boolean right) {
        return Direction.of(this.right, right);
    }

    public int move() {
        return move;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    @Override
    public String toString() {
        return left + ":" + right;
    }
}
