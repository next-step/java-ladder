package ladder.domain;

import ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Line {
    private final List<Point> points;

    private Line() {
        this(new ArrayList<>());
    }

    private Line(final List<Point> points) {
        this.points = points;
    }

    public static Line of(final int countOfPerson, PointStrategy pointStrategy) {
        return Stream.generate(pointStrategy::generator)
                .limit(countOfPerson)
                .collect(Collector.of(
                        Line::new,
                        (line, point) -> line.add(point, countOfPerson),
                        (a,b) -> {
                            throw new UnsupportedOperationException();
                        }
                ));
    }

    private void add(Boolean point, int totalCount) {
        int index = points.size();
        if (isFirst()) {
            points.add(Point.from(index, point));
            return;
        }

        if (mustFalse(totalCount)) {
            points.add(Point.from(index, Boolean.FALSE));
            return;
        }

        points.add(Point.from(index, point));
    }

    private boolean mustFalse(int totalCount) {
        return peekLast() || isLast(totalCount);
    }

    private boolean isFirst() {
        return points.isEmpty();
    }

    private boolean isLast(int countOfPerson) {
        return points.size() == countOfPerson - 1;
    }

    private boolean peekLast() {
        return points.get(points.size() - 1).getPoint();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
