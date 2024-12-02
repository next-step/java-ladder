package nextstep.ladder.domain.line.point;

public class Point {
    private final boolean left;
    private final boolean right;

    public Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("양쪽으로 동시에 이동할 수 없습니다.");
        }

        this.left = left;
        this.right = right;
    }

    public static Point first(boolean right) {
        return new Point(false, right);
    }

    public Point last() {
        return new Point(this.right, false);
    }

    public Point next(boolean nextRight) {
        return new Point(this.right, nextRight);
    }

    public boolean canMoveLeft() {
        return left;
    }

    public boolean canMoveRight() {
        return right;
    }

}
