package nextstep.ladder.domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.domain.Point.FALSE;
import static nextstep.ladder.domain.Point.TRUE;

public class HorizontalLine implements Iterable<Point> {
    private static final int FIRST_INDEX = 0;
    private List<Point> points;

    public static HorizontalLine of(int size) {
        HorizontalLine horizontalLine = new HorizontalLine();
        horizontalLine.points = IntStream.range(0, size)
                .mapToObj(i -> FALSE)
                .collect(Collectors.toList());
        return horizontalLine;
    }

    private HorizontalLine() {
    }

    public void makePointToTrue(int index) {
        if (isLast(index)) {
            return;
        } else if (!isFirst(index) && getBefore(index) == TRUE) {
            return;
        } else if (!isLast(index) && getAfter(index) == TRUE) {
            return;
        }

        points.set(index, TRUE);
    }

    public void makePointTo(int index, boolean hasRightDirection) {
        if (hasRightDirection) {
            makePointToTrue(index);
            return;
        }

        points.set(index, FALSE);
    }

    private boolean isFirst(int index) {
        return index == FIRST_INDEX;
    }

    private boolean isLast(int index) {
        return index == lastIndex();
    }

    private Point getBefore(int index) {
        if (isFirst(index)) {
            getPoint(FIRST_INDEX);
        }
        return getPoint(index - 1);
    }

    private Point getAfter(int index) {
        if (isLast(index)) {
            getPoint(lastIndex());
        }

        return getPoint(index + 1);
    }

    public int size() {
        return points.size();
    }

    private int lastIndex() {
        return size() - 1;
    }

    public Point getPoint(int index) {
        return points.get(index);
    }

    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
    }
}
