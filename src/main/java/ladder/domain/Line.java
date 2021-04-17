package ladder.domain;

import ladder.exception.PointListNullPointerException;
import ladder.strategy.LineGenerateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Line {

    private static final int ZERO = 0;
    private static final int ONE = 1;

    private final List<Point> points;

    private Line(List<Point> points) {
        validateNull(points);
        this.points = points;
    }

    private final void validateNull(List<Point> points) {
        if (Objects.isNull(points)) {
            throw new PointListNullPointerException();
        }
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
        IntStream.range(ZERO, countPerson - ONE)
                .forEach(beforeIndex -> points.add(generatePoint(points.get(beforeIndex), strategy)));
        return points;
    }

    private static final Point generatePoint(Point before, LineGenerateStrategy strategy) {
        if (before.hasPoint()) {
            return Point.of(Boolean.FALSE);
        }
        return Point.of(strategy.generateLine());
    }

    public final Stream<Point> stream() {
        return points.stream();
    }

    public final void run(List<Integer> list) {
        int beforePosition = list.get(ZERO);
        for (int index = ONE; index < list.size(); index++) {
            int nowPosition = list.get(index);
            if (points.get(index).hasPoint()) {
                list.set(index - ONE, nowPosition);
                list.set(index, beforePosition);
                continue;
            }
            beforePosition = nowPosition;
        }
    }
}
