package ladder.domain;

import ladder.domain.generator.BooleanGenerator;

import java.util.*;
import java.util.stream.IntStream;

public class Points {

    private static final int FIRST = 1;
    private List<Point> points;

    private Points(List<Point> points) {

        this.points = points;
    }

    public static Points of(List<Point> points) {

        return new Points(points);
    }

    public static Points createPoints(int width, BooleanGenerator booleanGenerator) {

        List<Point> points = new ArrayList<>();
        points.add(Point.first(booleanGenerator.generate()));
        IntStream.range(FIRST, width - 1)
                .mapToObj(position -> Point.middle(getLastPoint(points), booleanGenerator.generate()))
                .forEach(points::add);
        points.add(Point.last(getLastPoint(points)));
        return Points.of(points);
    }

    private static Point getLastPoint(List<Point> points) {

        return points.get(getLastIndex(points.size()));
    }

    private static int getLastIndex(int width) {

        return width - 1;
    }

    public List<Point> getPoints() {

        return Collections.unmodifiableList(points);
    }

    public Point getPoint(int position) {

        return points.get(position);
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
}
