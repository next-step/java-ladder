package ladder2.domain;

public class Point {

    private final boolean left;
    private final boolean right;

    private Point(boolean left, boolean right) {

        if (left && right) {
            throw new IllegalArgumentException("양방향 모두가 이동가능할 수는 없습니다.");
        }

        this.left = left;
        this.right = right;
    }

    public static Point of(boolean left, boolean right) {
        return new Point(left, right);
    }

    public static Point first(boolean right) {
        return of(false, right);
    }

    public Point last() {
        return of(this.right, false);
    }

    public Point next(boolean right) {
        return of(this.right, right);
    }

    public Direction move() {
        if (left) {
            return Direction.LEFT;
        }

        if (right) {
            return Direction.RIGHT;
        }

        return Direction.DOWN;
    }

    public boolean right() {
        return right;
    }
}
