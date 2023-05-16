package step3.domain;

public class Point {
    private final boolean left;
    private final boolean current;


    private Point(boolean left, boolean current) {
        validatePoint(left, current);
        this.left = left;
        this.current = current;
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public Point next() {
        return new Point(this.current, !this.current);
    }

    public Point last() {
        return new Point(this.current, false);
    }

    private void validatePoint(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException("유효하지 않는 포인트 입니다.");
        }
    }


    public Direction move() {
        if (current) {
            return Direction.RIGHT;
        }
        if (left) {
            return Direction.LEFT;
        }
        return Direction.SKIP;
    }


    public boolean getLeft() {
        return left;
    }

    public boolean getCurrent() {
        return current;
    }
}
