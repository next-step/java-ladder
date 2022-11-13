package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Point {

    private static final Random RANDOM = new Random();

    private boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public boolean isPoint() {
        return point;
    }

    public static Point addPoint(int point, List<Point> points) {
        if (point > 0 && isPreviousPointConnected(points.get(point - 1))) {
            return new Point(false);
        }
        return new Point(RANDOM.nextBoolean());
    }

    private static boolean isPreviousPointConnected(Point point) {
        return point.isPoint();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return point == point1.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
