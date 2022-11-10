package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.strategy.LinkStrategy;

public class Line {

    private final static String ERROR_NEGATIVE_VALUE = "0 이상의 값만 입력 가능합니다.";

    private final List<Point> points;
    private final List<Integer> linkedColumns = new ArrayList<>();

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
        linkedColumns.addAll(strategy.link(points.size() - 1));
    }

    public int move(final int currentColumnNumber) {
        if (linkedColumns.contains(currentColumnNumber)) {
            return currentColumnNumber + 1;
        }

        if (currentColumnNumber != 0 && linkedColumns.contains(currentColumnNumber - 1)) {
            return currentColumnNumber - 1;
        }

        return currentColumnNumber;
    }

    public boolean isLinkedPoint(final Point point) {
        return linkedColumns.contains(point.getY());
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
