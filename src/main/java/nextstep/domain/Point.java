package nextstep.domain;

public class Point {

    private static final int LEFT = -1;
    private static final int PASS = 0;
    private static final int RIGHT = 1;
    private boolean left;
    private boolean right;

    public Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("유효한 사다리가 아닙니다.");
        }
        this.left = left;
        this.right = right;
    }

    public static Point init(boolean right) {
        return new Point(false, right);
    }

    public Point last() {
        return new Point(this.right, false);
    }

    public Point insert(boolean right) {
        if (this.right) {
            return new Point(true, false);
        }
        return new Point(false, right);
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
