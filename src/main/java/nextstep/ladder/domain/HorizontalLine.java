package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HorizontalLine implements Iterable<Point> {
    private List<Point> points;

    public HorizontalLine(int size) {
        points = new ArrayList<>();
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
    }

    private boolean isLast(int index) {
        return index == getLastIndex();
    }

    private Point getAfter(int index) {
        if (isLast(index)) {
            return getPoint(getLastIndex());
        }

        return getPoint(index + 1);
    }

    public int size() {
        return points.size();
    }

    private int getLastIndex() {
        return size() - 1;
    }

    public Point getPoint(int index) {
        return points.get(index);
    }

    public int getNextIndex(int index) {
        Point point = points.get(index);
        if(point.hasRightDirection()) {
            return index + 1;
        } else if(point.hasLeftDirection()) {
            return index - 1;
        }

        return index;
    }

    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
    }
}
