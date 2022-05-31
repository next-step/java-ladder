package ladder.domain;

import ladder.constant.Direction;
import ladder.generator.PointGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {

    private static final int FIRST_LAST_COUNT = 2;
    private final List<Point> points;

    public Line(Positions positions) {
        List<Point> points = new ArrayList<>();
        Point point = initFirstPoint(points);
        point = initMiddlePoints(positions, points, point);
        initLastPoint(points, point);
        this.points = points;
    }

    private Point initFirstPoint(List<Point> points) {
        Point point = Point.first(PointGenerator.generate());
        points.add(point);
        return point;
    }

    private Point initMiddlePoints(Positions positions, List<Point> points, Point point) {
        for (int i = 0; i < positions.count() - FIRST_LAST_COUNT; i++) {
            point = point.nextRandom();
            points.add(point);
        }
        return point;
    }

    private void initLastPoint(List<Point> points, Point point) {
        points.add(point.last());
    }

    public Direction direction(Index index) {
        if(isConnectLeft(index)) {
            return Direction.LEFT;
        }
        if (isConnectRight(index)) {
            return Direction.RIGHT;
        }
        return Direction.PASS;
    }

    private boolean isConnectLeft(Index index) {
        return points.get(index.toInt()).isLeftConnected();
    }
    private boolean isConnectRight(Index index) {
        return points.get(index.toInt()).isRightConnected();
    }

    public List<Point> points() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}

