package ladder.domain.line;

import ladder.domain.point.Point;
import ladder.domain.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderLine {
    private static final Point START_POINT = Point.valueOf(false);

    private final List<Point> points;

    public LadderLine(int playersCount, PointStrategy pointStrategy) {
        this.points = createPoints(playersCount, pointStrategy);
    }

    public static LadderLine of(int playersCount, PointStrategy pointStrategy) {
        return new LadderLine(playersCount, pointStrategy);
    }

    public List<Point> createPoints(int playersCount, PointStrategy pointStrategy) {
        List<Point> points = new ArrayList<>();
        points.add(START_POINT);

        for (int index = 1; index < playersCount; index++) {
            points.add(makeLine(points.get(index - 1), pointStrategy));
        }

        return points;
    }

    private Point makeLine(Point point, PointStrategy pointStrategy) {
        if (point.isPoint()) {
            return Point.valueOf(false);
        }
        return Point.strategyOf(pointStrategy);
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
