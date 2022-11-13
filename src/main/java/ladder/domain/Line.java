package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.strategy.LinkStrategy;

public class Line {

    private final List<Point> points;
    private final List<Integer> linkedColumns = new ArrayList<>();

    public Line(final PositiveInt row, final PositiveInt lastColumn) {
        this.points = IntStream.range(0, lastColumn.getValue())
            .mapToObj(i -> new Point(row, new PositiveInt(i)))
            .collect(Collectors.toList());
    }

    public void link(final LinkStrategy strategy) {
        linkedColumns.addAll(strategy.link(points.size() - 1));
    }

    public int move(final int currentColumnNumber) {
        if (linkedColumns.contains(currentColumnNumber)) {
            return currentColumnNumber + 1;
        }

        if (currentColumnNumber == 0) {
            return currentColumnNumber;
        }

        int previous = currentColumnNumber - 1;
        if (linkedColumns.contains(previous)) {
            return previous;
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
