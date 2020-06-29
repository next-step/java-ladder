package domain;

public class Point {
    private final boolean left;
    private final boolean right;

    private Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Point of(Point before, boolean point) {
        return new Point(before.right, point);
    }

    public static Point createFirst(boolean point) {
        return new Point(false, point);
    }

    public static Point createLast(Point before) {
        return new Point(before.right, false);
    }

    public int nextIndex(int index) {
        if(left) {
            --index;
        }

        if(right) {
            ++index;
        }

        return index;
    }

    public boolean isNextConnect() {
        return right;
    }
}
