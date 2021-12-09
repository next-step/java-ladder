package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.*;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public static Line createLine(int players) {
        List<Point> points = new ArrayList<>();
        createFirstPoint(points);
        createAfterPoint(points, players);
        return new Line(points);
    }

    private static void createFirstPoint(List<Point> points) {
        points.add(Point.createFirstPoint());
    }

    private static void createAfterPoint(List<Point> points, int players) {
        range(0, players - 1)
                .forEach(index -> addPoint(points, index));
    }

    private static void addPoint(List<Point> points, int index) {
        if (points.get(index).isRight()) {
            points.add(Point.createPoint(index));
            return;
        }
        points.add(Point.createRandomPoint(index));
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

    @Override
    public String toString() {
        return points + " ";
    }


}
