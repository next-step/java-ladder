package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    private final List<Point> points;

    public Line(int pointCount, RungGenerator generator) {
        this(generatePoints(pointCount, generator));
    }

    public Line(boolean... line) {
        this(toPoints(line));
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    private static List<Point> toPoints(boolean[] line) {
        List<Point> points = new ArrayList<>(line.length + 1);
        points.add(Point.create(line[0]));

        for (int i = 1; i < line.length; i++) {
            points.add(points.get(i - 1).createNext(line[i]));
        }

        points.add(points.get(points.size() - 1).createLast());
        return points;
    }

    private static List<Point> generatePoints(int size, RungGenerator generator) {
        if (size < 1) {
            throw new IllegalArgumentException("Line size should be greater than 0");
        }

        List<Point> points = Stream.iterate(Point.create(generator), previous -> previous.createNext(generator))
                .limit(size - 1)
                .collect(Collectors.toList());

        points.add(points.get(points.size() - 1).createLast());
        return points;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int moveFrom(int point) {
        return points.get(point).move();
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
        return Objects.hashCode(points);
    }
}
