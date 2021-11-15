package nextstep.step2.domain;

import nextstep.step2.vo.BooleanGenerateStrategy;
import nextstep.step2.vo.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
    private static final int START_LINE = 0;

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line create(int endLine, BooleanGenerateStrategy strategy) {
        List<Point> points = new ArrayList<>();
        for(int i = START_LINE; i < endLine; i++) {
            points.add(makePoint(strategy, points));
        }

        return new Line(points);
    }

    private static Point makePoint(BooleanGenerateStrategy strategy, List<Point> points) {
        if(points.isEmpty()) {
            return Point.getCachedPoint(strategy.generate());
        }

        int now = points.size() - 1;
        if(points.get(now).equals(Point.TRUE)) {
            return Point.FALSE;
        }

        return Point.getCachedPoint(strategy.generate());
    }

    public List<Point> getPoints() {
        return points.stream()
                .map(Point::getValue)
                .map(Point::getCachedPoint)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
