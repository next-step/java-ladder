package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Line implements Iterable<Point> {
    private final List<Point> points;

    public Line (List<Point> points) {
        this.validate(points);
        this.points = new ArrayList<>(points);
    }

    public void validate(List<Point> points) {
        checkMoreThanTwoLinesAttached(points);
    }

    private void checkMoreThanTwoLinesAttached(List<Point> points) {
        boolean thisLineHasPoint = false;
        boolean nextLineHasPoint = false;
        for (int index = 0; index < points.size() - 1; index++) {
            thisLineHasPoint = pointHasLine(points, index);
            nextLineHasPoint = pointHasLine(points, index + 1);
            if (thisLineHasPoint && nextLineHasPoint) {
                throw new IllegalArgumentException("사다리는 가로 라인이 겹칠 수 없습니다.");
            }
        }
    }

    private static boolean pointHasLine(List<Point> points, int i) {
        return points.get(i).isPoint();
    }

    public List<Point> points() {
        return this.points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }

    @Override
    public Iterator<Point> iterator() {
        return this.points.iterator();
    }
}
