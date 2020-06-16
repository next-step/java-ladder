package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class Point {
    private static final Map<Integer, Point> POINTS;
    public static final int TRUE = 1;
    public static final int FALSE = 0;

    static {
        POINTS = new HashMap<>();
        POINTS.put(TRUE, new Point(true));
        POINTS.put(FALSE, new Point(false));
    }

    private boolean point;

    private Point(boolean point) {
        this.point = point;
    }

    public static Point of(boolean point) {
        if (point) {
            return POINTS.get(TRUE);
        }
        return POINTS.get(FALSE);
    }

    @Override
    public String toString() {
        if (point) {
            return "-----|";
        }
        return "     |";
    }
}
