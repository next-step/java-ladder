package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.strategy.LinkStrategy;

public class Line {

    private final static String ERROR_NEGATIVE_VALUE = "0 이상의 값만 입력 가능합니다.";

    private final List<Point> points;

    public Line(final int row, final int lastColumn) {
        validate(row);
        validate(lastColumn);
        this.points = IntStream.range(0, lastColumn)
            .mapToObj(i -> new Point(row, i))
            .collect(Collectors.toList());
    }

    private void validate(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_VALUE);
        }
    }

    public void link(final LinkStrategy strategy) {
        List<Integer> linked = strategy.link(points.size() - 1);
        points.stream()
            .filter(point -> linked.contains(point.getY()))
            .forEach(Point::link);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
