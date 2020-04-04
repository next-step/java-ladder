package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HorizontalLine implements Iterable<Point> {
    private List<Point> points;

    public HorizontalLine(int size, RightDirection rightDirection) {
        initPoints(size, rightDirection);
    }

    private void initPoints(int size, RightDirection rightDirection) {
        points = new ArrayList<>();
        int lastIndex = size - 1;

        Point beforePoint = Point.of(false);
        for (int i = 0; i < lastIndex; i++) {
            Point point =
                    createPoint(beforePoint, rightDirection.isAbleToRight());

            points.add(point);
            beforePoint = point;
        }
        points.add(Point.of(false));
    }

    private Point createPoint(Point beforePosition,
                              boolean isAbleToRight) {
        if (beforePosition.hasRightDirection()) {
            return Point.of(false);
        }

        return Point.of(isAbleToRight);
    }

    public int size() {
        return points.size();
    }

    protected Point last() {
        return points.get(lastIndex());
    }

    private int lastIndex() {
        return size() - 1;
    }

    public Point getPoint(int index) {
        return points.get(index);
    }

    public void reverse(int index) {
        Point point = points.get(index);
        points.set(index, point.reverse());
    }

    @Override public Iterator<Point> iterator() {
        return points.iterator();
    }
}
