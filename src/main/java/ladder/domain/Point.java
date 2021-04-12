package ladder.domain;

public final class Point {

    private final boolean point;

    private Point(boolean point) {
        this.point = point;
    }

    public static final Point of(boolean point) {
        return new Point(point);
    }

}
