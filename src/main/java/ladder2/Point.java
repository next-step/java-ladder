package ladder2;

public class Point {

    private final boolean left;
    private final boolean current;

    public Point(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException();
        }

        this.left = left;
        this.current = current;
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public Direction move() {
        if (current) {
            return Direction.Right;
        }

        if (left) {
            return Direction.Left;
        }
        return Direction.South;
    }

    public Point next(boolean current) {
        return new Point(this.current, current);
    }
}
