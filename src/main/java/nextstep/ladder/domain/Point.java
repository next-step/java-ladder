package nextstep.ladder.domain;

public class Point {

    private final boolean point;

    private Point(boolean point) {
        this.point = point;
    }

    public static Point of(boolean point) {
        return new Point(point);
    }

    public static Point of(BooleanStrategy booleanStrategy) {
        return new Point(booleanStrategy.value(false));
    }

    public Point nextPoint(BooleanStrategy booleanStrategy) {
        return of(booleanStrategy.value(point));
    }

    public boolean value() {
        return point;
    }
}
