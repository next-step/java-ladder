package ladder.domain;

import java.util.*;

public class Line {

    private final List<Point> points;

    public Line (int countOfPerson, DirectionRule directionRule) {
        this.points = generateLine(countOfPerson, directionRule);
    }

    public Line (List<Point> points) {
        this.points = points;
    }

    private static List<Point> generateLine(int countOfPerson, DirectionRule directionRule) {
        LinkedList<Point> points = new LinkedList<>();

        Point prePoint = Point.first(directionRule);
        points.addFirst(prePoint);

        for (int i = 1; i < countOfPerson - 1; i++) {
            prePoint = Point.next(prePoint, directionRule);
            points.add(prePoint);
        }

        points.addLast(Point.last(prePoint));
        return points;
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
