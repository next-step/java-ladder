package ladder.domain;

import ladder.strategy.LineGenerateStrategy;

import java.util.ArrayList;
import java.util.List;

public final class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static final Line of(List<Point> points) {
        return new Line(points);
    }

    public static final Line of(int countPerson, LineGenerateStrategy strategy) {
        return of(generatePoints(countPerson, strategy));
    }

    private static final List<Point> generatePoints(int countPerson, LineGenerateStrategy strategy) {
        List<Point> points = new ArrayList<>();
        points.add(Point.first());
        for (int beforeIndex = 0; beforeIndex < countPerson - 1; beforeIndex++) {
            points.add(generatePoint(points.get(beforeIndex), strategy));
        }
        return points;
    }

    private static Point generatePoint(Point before, LineGenerateStrategy strategy) {
        if (before.isTrue()) {
            return Point.of(Boolean.FALSE);
        }
        return Point.of(strategy.generateLine());
    }

}
