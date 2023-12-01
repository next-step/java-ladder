package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class Line implements Iterable<Point> {
    private final List<Point> points;

    public Line (List<Point> points) {
        this.validate(points);
        this.points = new ArrayList<>(points);
    }

    public void validate(List<Point> points) {
        checkPointsSizeIsValid(points);
        checkMoreThanTwoLinesAttached(points);
    }

    private void checkPointsSizeIsValid(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException(("라인은 Point가 적어도 1개 이상 존재해야 합니다."));
        }
    }

    private void checkMoreThanTwoLinesAttached(List<Point> points) {
        IntStream.range(1, points.size())
                .filter(index -> lefAndCurrentHaveLines(points, index))
                .findFirst()
                .ifPresent(index -> {
                    throw new IllegalArgumentException("사다리는 가로 라인이 겹칠 수 없습니다.");
                });
    }

    private boolean lefAndCurrentHaveLines(List<Point> points, int index) {
        return leftHasLine(points, index) && currentHasLine(points, index);
    }

    private static boolean leftHasLine(List<Point> points, int index) {
        return points.get(index - 1).isPoint();
    }

    private static boolean currentHasLine(List<Point> points, int index) {
        return points.get(index).isPoint();
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
