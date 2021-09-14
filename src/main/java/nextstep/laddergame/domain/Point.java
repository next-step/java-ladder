package nextstep.laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Point {

    private static final int FIRST_POINT_INDEX = 0;
    private static final int GAP_BETWEEN_INDEX = 1;

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static List<Point> listOf(List<LineConnection> connections) {
        List<Point> points = new ArrayList<>();
        points.add(first(connections.get(FIRST_POINT_INDEX)));
        for (int i = 1; i < connections.size(); ++i) {
            Point prev = points.get(i-1);
            points.add(prev.next(connections.get(i)));
        }
        points.add(last(points));
        return Collections.unmodifiableList(points);
    }

    private static Point first(LineConnection rightConnection) {
        if (rightConnection.isConnected()) {
            return new Point(FIRST_POINT_INDEX, Direction.RIGHT);
        }
        return new Point(FIRST_POINT_INDEX, Direction.DOWN);
    }

    private static Point last(List<Point> points) {
        return points.get(points.size() - GAP_BETWEEN_INDEX)
                .next(LineConnection.UNCONNECTED);
    }

    private Point next(LineConnection rightConnectionOfNextPoint) {
        if (this.direction.isRight() && rightConnectionOfNextPoint.isConnected()) {
            throw new IllegalArgumentException("연속으로 연결된 포인트가 존재합니다.");
        }
        if (rightConnectionOfNextPoint.isConnected()) {
            return new Point(index + GAP_BETWEEN_INDEX, Direction.RIGHT);
        }
        if (this.direction.isRight()) {
            return new Point(index + GAP_BETWEEN_INDEX, Direction.LEFT);
        }
        return new Point(index + GAP_BETWEEN_INDEX, Direction.DOWN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        if (index != point.index) return false;
        return direction == point.direction;
    }

    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }

    public int move() {
        return direction.move(index);
    }
}
