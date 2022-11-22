package game.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    private Line(int numOfPeople, ValueStrategy valueStrategy) {
        points = new ArrayList<>();
        points.add(Point.first(valueStrategy.generateBoolean()));
        for (int count = 1; count <= numOfPeople - 2; count++) {
            points.add(Point.next(count, Direction.next(points.get(count - 1).direction().isRight(), valueStrategy.generateBoolean())));
        }
        points.add(Point.next(numOfPeople - 1, Direction.of(points.get(numOfPeople - 2).direction().isRight(), false)));
    }

    public static Line of(int numOfPeople, ValueStrategy valueStrategy) {
        return new Line(numOfPeople, valueStrategy);
    }

    public List<Point> points() {
        return points;
    }

    public int movePoint(int path) {
        return points.get(path).move();
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
