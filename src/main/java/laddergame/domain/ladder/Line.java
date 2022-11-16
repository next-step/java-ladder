package laddergame.domain.ladder;

import laddergame.util.ValueGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(Point... points) {
        return new Line(Arrays.stream(points)
                .collect(Collectors.toList()));
    }

    public static Line create(int width, ValueGenerator generator) {
        List<Point> points = new ArrayList<>();
        Point previous = Point.first(generator.generate());
        points.add(previous);
        for (int i = 1; i < width - 1; i++) {
            Point now = previous.next(generator.generate());
            points.add(now);
            previous = now;
        }
        points.add(previous.last());
        return new Line(points);
    }

    public int move(int index) {
        return points.get(index).move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String
    toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
