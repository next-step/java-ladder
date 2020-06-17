package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {

    private final Points points;

    public Line(Points points) {
        this.points = points;
    }

    public static Line init(int sizeOfPerson, DirectionPredicate predicate) {
        List<Point> pointList = new ArrayList<>();

        Point first = initFirst(predicate);
        pointList.add(first);
        pointList.addAll(initBody(first, predicate, sizeOfPerson - 2));
        pointList.add(initLast(pointList.get(pointList.size() - 1)));

        Points points = Points.newInstance(pointList);
        return new Line(points);
    }

    private static Point initFirst(DirectionPredicate predicate) {
        return Point.first(predicate);
    }

    private static List<Point> initBody(Point fist, DirectionPredicate predicate, int bodySize) {
        List<Point> points = new ArrayList<>();
        points.add(fist.next(predicate));

        IntStream.range(0, bodySize - 1)
                .mapToObj(points::get)
                .map(point -> point.next(predicate))
                .forEach(points::add);

        return points;
    }

    private static Point initLast(Point point) {
        return point.last();
    }

    public int move(int position) {
        return points.move(position);
    }

    public List<Point> getPoints() {
        return points.getPoints();
    }

    public int sizeOfPositions() {
        return points.size();
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
