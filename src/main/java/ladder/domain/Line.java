package ladder.domain;

import java.util.*;
import static ladder.domain.PointGenerator.hasMovable;

public class Line {

    private final List<Point> points;

    public Line(int countOfPerson) {
        this.points = generateLine(countOfPerson);
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    private static List<Point> generateLine(int countOfPerson) {
        List<Point> points = new ArrayList<>(countOfPerson);
        Point point = initFirst(points);
        for (int i = 1; i < countOfPerson - 1; i++) {
            point = Point.next(point, hasMovable());
            points.add(point);
        }
        initLast(points, point);
        return points;
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(hasMovable());
        points.add(point);
        return point;
    }

    private static void initLast(List<Point> points, Point prePoint) {
        Point point = Point.last(prePoint);
        points.add(point);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int movePoint(int position) {
        return this.points.get(position).movePoint(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
