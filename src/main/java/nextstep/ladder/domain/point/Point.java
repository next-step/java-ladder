package nextstep.ladder.domain.point;

public class Point {

    private final boolean hasLadder;

    private Point(boolean hasLadder) {
        this.hasLadder = hasLadder;
    }

    public static Point of(boolean hasLadder) {
        return new Point(hasLadder);
    }

    public static Point first(PointGenerator pointGenerator) {
        return Point.of(pointGenerator.hasLadder());
    }

    public Point next(PointGenerator pointGenerator) {
        if (hasLadder) {
            return Point.of(false);
        }

        return Point.of(pointGenerator.hasLadder());
    }

    public boolean isValid(Point pre) {
        if (!hasLadder) {
            return true;
        }

        return !pre.hasLadder;
    }

    public boolean hasLadder() {
        return this.hasLadder;
    }
}
