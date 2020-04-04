package nextstep.ladder.domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HorizontalLine implements Iterable<Point> {
    private List<Point> points;

    public static HorizontalLine of(int size) {
        HorizontalLine horizontalLine = new HorizontalLine();
        horizontalLine.points = IntStream.range(0, size)
                .mapToObj(i -> Point.of(false))
                .collect(Collectors.toList());
        return horizontalLine;
    }

    private HorizontalLine() {
    }

    public void makePointToTrue(int index) {
        if (index == lastIndex()) {
            return;
        }

        if (index != 0 && points.get(index - 1).hasRightDirection()) {
            return;
        }

        points.set(index, Point.of(true));
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

    public void reverse(int index) {
        if (index == lastIndex()) {
            return;
        }
        Point point = points.get(index);
        points.set(index, point.reverse());
    }

    @Override public Iterator<Point> iterator() {
        return points.iterator();
    }
}
