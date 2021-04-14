package ladder.domain;

public final class Point {

    private final boolean point;

    public static final Point of(boolean point) {
        return new Point(point);
    }

    private Point(boolean point) {
        this.point = point;
    }

    public static final Point first() {
        return new Point(Boolean.FALSE);
    }

    public final boolean isTrue() {
        return point == Boolean.TRUE;
    }
}
