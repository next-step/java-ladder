package ladder.domain.ladder;

public class Point {
    private final int position;
    private final boolean left;
    private final boolean right;

    private Point(int position, boolean left, boolean right) {
        this.position = position;
        this.left = left;
        this.right = right;
    }

    public static Point createFirstPoint(boolean right) {
        return new Point(0, false, right);
    }

    Point next(boolean newRight) {
        if (right) {
            return new Point(position + 1, true, false);
        }
        return new Point(position + 1, false, newRight);
    }

    Point last() {
        return new Point(position + 1, left, false);
    }

    public boolean isMovableRight() {
        return right;
    }
}
