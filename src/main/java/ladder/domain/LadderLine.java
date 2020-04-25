package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLine {
    private final List<Point> points;

    public static LadderLine from(final LadderLineInfo ladderLineInfo) {
        List<Point> points = new ArrayList<>();
        Point lastPoint = initFirstPoint(points, ladderLineInfo.createDirection());
        int middlePointCount = ladderLineInfo.lineCount() - 2;
        for (int i = 0; i < middlePointCount; i++) {
            lastPoint = initMiddlePoint(points, lastPoint, ladderLineInfo.createDirection());
        }
        initLastPoint(points, lastPoint);
        return new LadderLine(points);
    }

    private static Point initFirstPoint(final List<Point> points, final boolean direction) {
        Point first = Point.first(direction);
        points.add(first);
        return first;
    }

    private static Point initMiddlePoint(final List<Point> points, Point lastPoint, final boolean direction) {
        lastPoint = lastPoint.next(direction);
        points.add(lastPoint);
        return lastPoint;
    }

    private static void initLastPoint(final List<Point> points, final Point point) {
        points.add(point.last());
    }

    public LadderLine(final List<Point> points) {
        this.points = Collections.unmodifiableList(new ArrayList<>(points));
    }

    public Position move(final Position currentPosition) {
        return points.get(currentPosition.toInt()).move();
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderLine)) return false;
        LadderLine line = (LadderLine) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
