package ladder.domain.line;

import ladder.domain.point.Point;
import ladder.domain.point.Position;
import ladder.domain.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderLine {
    private static final int FIRST_POINT_INDEX = 0;
    private static final int EXCEPT_POINT_COUNT = 1;

    private final List<Point> points;

    private LadderLine(int playersCount, PointStrategy pointStrategy) {
        this.points = createLine(playersCount, pointStrategy);
    }

    public static LadderLine of(int playersCount, PointStrategy pointStrategy) {
        return new LadderLine(playersCount, pointStrategy);
    }

    private List<Point> createLine(int playersCount, PointStrategy pointStrategy) {
        List<Point> points = new ArrayList<>();

        markFirstPoint(points, pointStrategy);
        generatePoints(points, pointStrategy, playersCount);
        markLastPoint(points);

        return points;
    }

    private void markFirstPoint(List<Point> points, PointStrategy pointStrategy) {
        points.add(Point.first(pointStrategy));
    }

    private void generatePoints(List<Point> points, PointStrategy pointStrategy, int playersCount) {
        Point point = points.get(FIRST_POINT_INDEX);

        for (int i = 1; i < playersCount - EXCEPT_POINT_COUNT; i++) {
            point = point.next(pointStrategy);
            points.add(point);
        }
    }

    private void markLastPoint(List<Point> points) {
        Point point = points.get(points.size() - EXCEPT_POINT_COUNT);
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
