package nextstep.ladder.domain.point;

public class Point {

    private final boolean hasRight;

    private Point(boolean hasRight) {
        this.hasRight = hasRight;
    }

    private static Point of(boolean hasRight) {
        return new Point(hasRight);
    }

    public static Point first(PointGenerator pointGenerator) {
        return Point.of(pointGenerator.hasRight());
    }

    public static Point last() {
        return Point.of(false);
    }

    public Point next(PointGenerator pointGenerator) {
        if (hasRight) {
            return Point.of(false);
        }

        return Point.of(pointGenerator.hasRight());
    }

    public boolean isValid(Point pre) {
        if (!hasRight) {
            return true;
        }

        return !pre.hasRight;
    }

    public boolean hasLadder() {
        return this.hasRight;
    }
}
