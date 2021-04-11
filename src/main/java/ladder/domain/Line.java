package ladder.domain;

import ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Line {
    private final List<Boolean> points;

    private Line() {
        this(new ArrayList<>());
    }

    private Line(final List<Boolean> points) {
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
        if (isFirst()) {
            points.add(point);
            return;
        }

        if (mustFalse(totalCount)) {
            points.add(Boolean.FALSE);
            return;
        }

        points.add(point);
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
        return points.get(points.size() - 1);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
