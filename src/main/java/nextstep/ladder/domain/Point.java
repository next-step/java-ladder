package nextstep.ladder.domain;

public class Point {

    private final boolean point;
    private final BooleanStrategy booleanStrategy;

    private Point(boolean point, BooleanStrategy booleanStrategy) {
        this.point = point;
        this.booleanStrategy = booleanStrategy;
    }

    public static Point from(boolean point) {
        return new Point(point, new RandomBooleanStrategy());
    }

    public static Point from(BooleanStrategy booleanStrategy) {
        return new Point(booleanStrategy.value(), booleanStrategy);
    }

    public Point nextPoint() {
        if (point) {
            return from(false);
        }
        return from(booleanStrategy.value());
    }

    public boolean value() {
        return point;
    }
}
