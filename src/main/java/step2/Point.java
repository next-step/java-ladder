package step2;

import java.util.List;

public class Point {

    private final boolean point;

    private Point(boolean point) {
        this.point = point;
    }

    public static Point validPrePoint(List<Point> points) {
        boolean point = RandomGeneratorPoint.generatorRandomPoint();

        if (point && points.size() > 0 && points.get(points.size() - 1).point) {
            return new Point(false);
        }

        return new Point(point);
    }

    public boolean isPoint() {
        return point;
    }
}
