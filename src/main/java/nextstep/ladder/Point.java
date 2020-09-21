package nextstep.ladder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    public boolean checkConnected(Point next) {
        return this.connection && next.connection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return connection == point.connection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(connection);
    }
}
