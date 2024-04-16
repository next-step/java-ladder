package domain;

public class Point {
    private boolean isLast;
    private final boolean left;
    private final boolean current;

    public static Point first(boolean current) {
        return new Point(false, false, current);
    }

    public static Point last(boolean left) {
        return new Point(true, left, false);
    }

    public static Point of(boolean left, boolean current) {
        return new Point(false, left, current);
    }

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

    private Point(boolean isLast, boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException();
        }
        this.isLast = isLast;
        this.left = left;
        this.current = current;
    }

    public boolean isExist() {
        return current;
    }

    public boolean hasCurrent() {
        return current;
    }

    public boolean isLast() {
        return isLast;
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
