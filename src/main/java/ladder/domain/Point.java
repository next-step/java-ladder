package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class Point {
    public static final int TRUE = 1;
    public static final int FALSE = 0;
    private static final Map<Integer, Point> POINTS;

    static {
        POINTS = new HashMap<>();
        POINTS.put(TRUE, new Point(true));
        POINTS.put(FALSE, new Point(false));
    }

    private boolean point;

    private Point(boolean point) {
        this.point = point;
    }

    public static Point valueOf(boolean point) {
        if (point) {
            return POINTS.get(TRUE);
        }
        return POINTS.get(FALSE);
    }

    public Point checkOverlap(boolean random) {
        if (point) {
            return Point.valueOf(false);
        }
        return Point.valueOf(random);
    }

    public boolean isPoint() {
        return point;
    }
}
