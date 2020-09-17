package nextstep.ladder;

import java.util.HashMap;
import java.util.Map;

public class Point {

    private final boolean connection;
    private static final Map<Boolean, Point> POINTS = new HashMap<>();

    static {
        POINTS.put(true, new Point(true));
        POINTS.put(false, new Point(false));
    }

    private Point(boolean connection) {
        this.connection = connection;
    }

    public static Point of(boolean connection) {
        return POINTS.get(connection);
    }
}
