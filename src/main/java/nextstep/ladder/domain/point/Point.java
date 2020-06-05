package nextstep.ladder.domain.point;

public class Point {

    private final boolean hasRight;
    private final boolean hasLeft;

    private Point(boolean hasLeft, boolean hasRight) {
        this.hasLeft = hasLeft;
        this.hasRight = hasRight;
    }

    private static Point of(boolean hasLeft, boolean hasRight) {
        return new Point(hasLeft, hasRight);
    }

    public static Point first(PointGenerator pointGenerator) {
        return Point.of(false, pointGenerator.hasRight());
    }

    public Point last() {
        return Point.of(this.hasRight, false);
    }

    public Point next(PointGenerator pointGenerator) {
        boolean nextRight = this.hasRight ? false : pointGenerator.hasRight();
        return Point.of(this.hasRight, nextRight);
    }

    public boolean isValid(Point pre) {
        if (!this.hasRight) {
            return true;
        }

        return !pre.hasRight;
    }

    public boolean hasRight() {
        return this.hasRight;
    }

    public int move(int current) {
        if (this.hasRight) {
            return current + 1;
        }

        if (hasLeft) {
            return current - 1;
        }

        return current;
    }
}
