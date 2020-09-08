package ladder.domain.line;

import ladder.domain.point.Point;
import ladder.domain.point.Position;
import ladder.domain.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderLine {
    private final List<Point> points;

    private LadderLine(int playersCount, PointStrategy pointStrategy) {
        this.points = firstLine(playersCount, pointStrategy);
    }

    public static LadderLine of(int playersCount, PointStrategy pointStrategy) {
        return new LadderLine(playersCount, pointStrategy);
    }

    public List<Point> firstLine(int playersCount, PointStrategy pointStrategy) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(pointStrategy);
        point = generatePoints(points, pointStrategy, playersCount, point);
        markLastPoint(points, point);
        return points;
    }

    private Point generatePoints(List<Point> points, PointStrategy pointStrategy, int playersCount, Point point) {
        points.add(point);
        for (int i = 1; i < playersCount - 1; i++) {
            point = point.next(pointStrategy);
            points.add(point);
        }
        return point;
    }

    private void markLastPoint(List<Point> points, Point point) {
        points.add(point.last());
    }

    public Position move(Position position) {
        return points.get(position.location()).move();
    }

    public List<Point> getPoints() {
        return points;
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
