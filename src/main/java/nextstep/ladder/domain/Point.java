package nextstep.ladder.domain;

public class Point {

    private final boolean point;
    private final BooleanStrategy booleanStrategy;

    private Point(boolean point, BooleanStrategy booleanStrategy) {
        this.point = point;
        this.booleanStrategy = booleanStrategy;
    }

    public static Point of(boolean point, BooleanStrategy booleanStrategy) {
        return new Point(point, booleanStrategy);
    }

    public static Point of(boolean point) {
        return new Point(point, new RandomBooleanStrategy());
    }

    public static Point of(BooleanStrategy booleanStrategy) {
        return new Point(booleanStrategy.value(), booleanStrategy);
    }

    public Point nextPoint() {
        if (point) {
            return of(false, booleanStrategy);
        }
        return of(booleanStrategy);
    }

    public boolean value() {
        return point;
    }
}
