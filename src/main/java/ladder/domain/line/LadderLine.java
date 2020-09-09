package ladder.domain.line;

import ladder.domain.point.Point;
import ladder.domain.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderLine {
    private final List<Point> points;

    private LadderLine(int playersCount, PointStrategy pointStrategy) {
        this.points = createPoints(playersCount, pointStrategy);
    }

    public static LadderLine of(int playersCount, PointStrategy pointStrategy) {
        return new LadderLine(playersCount, pointStrategy);
    }

    public List<Point> createPoints(int playersCount, PointStrategy pointStrategy) {
        List<Point> points = new ArrayList<>();

        Point point = this.createFirstPoint(points, pointStrategy);
        point = this.createNextPoints(points, pointStrategy, playersCount, point);
        this.createLastPoint(points, point);

        return points;
    }

    private Point createFirstPoint(List<Point> points, PointStrategy pointStrategy) {
        Point point = Point.first(pointStrategy);
        points.add(point);
        return point;
    }

    private Point createNextPoints(List<Point> points, PointStrategy pointStrategy, int playersCount, Point point) {
        for (int i = 1; i < playersCount - 1; i++) {
            point = point.next(pointStrategy);
            points.add(point);
        }
        return point;
    }

    private void createLastPoint(List<Point> points, Point point) {
        points.add(point.last());
    }

    public int move(int position) {
        return points.get(position).move();
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
