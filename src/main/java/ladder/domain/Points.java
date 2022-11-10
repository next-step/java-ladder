package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Points {
    private final List<Point> points;

    public static Points createPointsByNames(List<String> names) {
        List<Point> points = IntStream.range(0, names.size()).boxed()
                .map(i -> new Point(names.get(i), i, names.size()))
                .collect(Collectors.toList());
        return new Points(points);
    }

    public Points(List<Point> points) {
        this.points = points;
    }

    public Points movedPoints(MoveStrategy moveStrategy) {
        List<Point> movedPoints = this.points.stream()
                .map(moveStrategy::move)
                .collect(Collectors.toList());
        return new Points(movedPoints);
    }

    public Points filteredPoints(String name) {
        if (name.equals("all")) {
            return allPoints();
        }
        List<Point> filteredPoints = new ArrayList<>(List.of(matchedPoint(name)));
        return new Points(filteredPoints);
    }

    public int size() {
        return points.size();
    }

    public int pointNameMaxSize() {
        return points.stream()
                .mapToInt(Point::nameSize)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public Point get(int location) {
        return points.stream()
                .filter(point -> point.isMatch(location))
                .findFirst()
                .orElseThrow(IndexOutOfBoundsException::new);
    }

    public List<Point> points() {
        return points;
    }

    private Points allPoints() {
        return this;
    }

    private Point matchedPoint(String name) {
        return points.stream()
                .filter(point -> point.isNameEqual(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("입력한 이름에 해당하는 point가 없습니다. 입력한 이름: " + name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points1 = (Points) o;
        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Points{" +
                "points=" + points +
                '}';
    }
}
