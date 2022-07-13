package ladder.domain.second;

public class Point {
    private boolean left;
    private boolean right;

    private Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("양쪽에 사다리 선이 생성될 수 없습니다.");
        }
        this.left = left;
        this.right = right;
    }

    public static Point first(boolean right) {
        return new Point(false, right);
    }

    public Point next(boolean right) {
        return new Point(this.right, right);
    }

    public Direction move() {
        if (left) {
            return Direction.LEFT;
        }

        if (right) {
            return Direction.RIGHT;
        }
        return Direction.PASS;
    }

    public Point last() {
        return new Point(this.right, false);
    }

    public boolean isRight() {
        return right;
    }
}
