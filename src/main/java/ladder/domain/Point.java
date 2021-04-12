package ladder.domain;

public final class Point {

    public static final boolean FALSE = false;

    private final boolean point;

    private Point(boolean point) {
        this.point = point;
    }

    public static final Point of(boolean point) {
        return new Point(point);
    }

    public static final Point first() {
        return new Point(FALSE);
    }
}
