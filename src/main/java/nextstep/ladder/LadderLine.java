package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderLine {

    private static final int INDEX_UNIT = 1;
    private static final int MIN_START_INDEX = 0;

    private final List<Point> points;

    public LadderLine(List<Point> points) {
        checkNotEmpty(points);
        this.points = points;
    }

    private void checkNotEmpty(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new RequiredArgumentException();
        }
    }

    // TODO: null체크
    public static LadderLine of(LadderWidth width, WayRule wayRule) {
        List<Point> points = new ArrayList<>();

        Point first = Point.first(wayRule);
        points.add(first);

        List<Point> bodyPoints = bodyOf(width.bodyWidth(), first, wayRule);
        points.addAll(bodyPoints);

        Point endOfPoints = points.get(points.size() - INDEX_UNIT);
        points.add(endOfPoints.last());

        return new LadderLine(points);
    }

    private static List<Point> bodyOf(int bodySize, Point first, WayRule wayRule) {
        List<Point> bodyPoints = new ArrayList<>();
        for (int currentSize = 0; currentSize < bodySize; currentSize++) {
            first = first.next(wayRule);
            bodyPoints.add(first);
        }
        return bodyPoints;
    }

    public int move(int startIndex) {
        checkRange(startIndex);
        Point targetPoint = points.get(startIndex);
        return targetPoint.move();
    }

    private void checkRange(int startIndex) {
        if (startIndex < MIN_START_INDEX || startIndex >= points.size()) {
            throw new OutOfRangeIndexException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
