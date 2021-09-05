package step2.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
    private final List<Point> points;

    public Line(int numberOfUser, ValueStrategy valueStrategy) {
        points = Point.generatePoints(numberOfUser, valueStrategy);

    }

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Boolean> getLine() {
        return points.stream()
                        .map(Point::getCurrent)
                        .collect(Collectors.toList());
    }

    public int changeIndex(int index) {
        Point point = points.get(index);
        return index + Direction.findDirection(point).getMove();
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
