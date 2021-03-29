package laddarGame.domain;

import java.util.HashMap;
import java.util.Map;

public class Point {

    private final boolean point;
    private static final Map<Boolean, Point> points = new HashMap<>();

    static {
        points.put(true, new Point(true));
        points.put(false, new Point(false));
    }

    private Point(boolean point) {
        this.point = point;
    }

    public static Point of(boolean point) {
        return points.get(point);
    }

    public boolean toBoolean() {
        return point;
    }
}
