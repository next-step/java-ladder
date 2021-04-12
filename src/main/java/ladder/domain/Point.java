package ladder.domain;

public final class Point {

    private static final boolean FALSE = false;
    private static final boolean TRUE = true;

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

    public final boolean isTrue() {
        return point == TRUE;
    }
}
