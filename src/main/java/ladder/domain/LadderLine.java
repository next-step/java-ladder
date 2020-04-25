package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLine {
    private final List<Point> points;

    public static LadderLine of(final int userCount, final DirectionCreator directionCreator) {
        List<Point> points = new ArrayList<>();
        Point lastPoint = initFirstPoint(points, directionCreator);
        int middlePointCount = userCount - 2;
        for (int i = 0; i < middlePointCount; i++) {
            lastPoint = initMiddlePoint(points, lastPoint, directionCreator);
        }
        initLastPoint(points, lastPoint);
        return new LadderLine(points);
    }

    private static Point initMiddlePoint(List<Point> points, Point lastPoint, DirectionCreator directionCreator) {
        lastPoint = lastPoint.next(directionCreator.create());
        points.add(lastPoint);
        return lastPoint;
    }

    private static Point initFirstPoint(List<Point> points, DirectionCreator directionCreator) {
        Point first = Point.first(directionCreator.create());
        points.add(first);
        return first;
    }

    private static void initLastPoint(List<Point> points, Point point) {
        points.add(point.last());
    }

    public LadderLine(List<Point> points) {
        this.points = Collections.unmodifiableList(new ArrayList<>(points));
    }

    public Position move(Position currentPosition) {
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
