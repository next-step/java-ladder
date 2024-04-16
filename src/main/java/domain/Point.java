package domain;

public class Point {
    private final boolean left;
    private final boolean current;

    public Point(boolean current) {
        this(false, current);
    }
    public Point(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.current = current;
    }

    public boolean isExist() {
        return current;
    }

    public PointDirection move() {
        if (left) {
            return PointDirection.LEFT;
        }
        if (current) {
            return PointDirection.RIGHT;
        }
        return PointDirection.DOWN;
    }
}
