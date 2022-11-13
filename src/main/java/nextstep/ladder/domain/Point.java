package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Point {

    private static final Random RANDOM = new Random();

    private boolean connection;

    public Point(boolean connection) {
        this.connection = connection;
    }

    public boolean isConnection() {
        return connection;
    }

    public static Point addPoint(int point, List<Point> points) {
        if (point > 0 && isPreviousPointConnected(points.get(point - 1))) {
            return new Point(false);
        }
        return new Point(RANDOM.nextBoolean());
    }

    private static boolean isPreviousPointConnected(Point point) {
        return point.isConnection();
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
