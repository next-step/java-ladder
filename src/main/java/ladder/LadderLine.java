package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ladder.LadderPointGenerator.generatePoint;

public class LadderLine {
    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine of(int sizeOfPerson, PointConnectStrategy pointConnectStrategy) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, pointConnectStrategy);
        point = initBody(sizeOfPerson, points, point, pointConnectStrategy);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initFirst(List<Point> points, PointConnectStrategy pointConnectStrategy) {
        Point point = Point.first(pointConnectStrategy.isConnected());
        points.add(point);
        return point;
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point, PointConnectStrategy pointConnectStrategy) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(pointConnectStrategy.isConnected());
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public boolean isConnected(int left, int right) {
        return points.get(left).isRightConnected() && points.get(right).isleftConnected();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
