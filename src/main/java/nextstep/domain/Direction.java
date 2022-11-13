package nextstep.domain;

public class Direction {

    private static final int LEFT = -1;
    private static final int PASS = 0;
    private static final int RIGHT = 1;
    private boolean left;
    private boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("그 방향으로 갈 수 없습니다.");
        }
        this.left = left;
        this.right = right;
    }

    public static Direction init(boolean right) {
        return new Direction(false, right);
    }

    public Direction last() {
        return new Direction(this.right, false);
    }

    public Direction insert(boolean right) {
        if (this.right) {
            return new Direction(true, false);
        }
        return new Direction(false, right);
    }

    public int move() {
        if (left) {
            return LEFT;
        }
        if (right) {
            return RIGHT;
        }
        return PASS;
    }

    public boolean isPoint() {
        return left;
    }
}
