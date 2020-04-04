package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Line implements Iterable<Point> {
    private List<Point> points;

    public Line(int size, RightDirection rightDirection) {
        initPoints(size, rightDirection);
    }

    private void initPoints(int size, RightDirection rightDirection) {
        points = new ArrayList<>();
        int lastIndex = size - 1;
        // todo refactor
        for (int i = 0; i < lastIndex; i++) {
            boolean randomPoint = rightDirection.isAbleToRight();
            if (i != 0 && points.get(i - 1).hasRightDirection() && randomPoint) {
                randomPoint = false;
            }
            points.add(Point.of(randomPoint));
        }
        points.add(Point.of(false));
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
