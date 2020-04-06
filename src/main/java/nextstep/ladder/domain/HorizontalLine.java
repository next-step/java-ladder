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

    public HorizontalLine(int size) {
        points = new ArrayList();
        for(int i = 0; i < size; i++) {
            points.add(new Point());
        }
    }

    public void makeDirection(int index) {
        if (isLast(index)) {
            return;
        }
        Point point = getPoint(index);
        Point afterPoint = getAfter(index);
        if (afterPoint.hasRightDirection() || point.hasLeftDirection()) {
            return;
        }
        point.setRightDirection(true);
        afterPoint.setLeftDirection(true);
    }

    public void makeDirectionTo(int index, boolean hasRightDirection) {
        if (hasRightDirection) {
            makeDirection(index);
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
