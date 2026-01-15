package nextstep.ladder.domain;

public class Point {
    private final int index;
    private final boolean left;
    private final boolean right;

    private Point(int index, boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("연속된 가로선은 허용되지 않습니다.");
        }
        this.index = index;
        this.left = left;
        this.right = right;
    }

    public static Point first(boolean right) {
        return new Point(0, false, right);
    }

    public Point next(boolean right) {
        return new Point(this.index + 1, this.right, right);
    }

    public Point last() {
        return new Point(this.index + 1, this.right, false);
    }

    public int move() {
        if (left) {
            return index - 1;
        }
        if (right) {
            return index + 1;
        }
        return index;
    }

    public boolean hasRightConnection() {
        return right;
    }
}