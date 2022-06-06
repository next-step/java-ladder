package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Point {
    private Position position;
    private boolean bridge;

    private Point(Position position, boolean bridge) {
        this.position = position;
        this.bridge = bridge;
    }

    public static Point of(int position, boolean bridge) {
        return Point.of(Position.from(position), bridge);
    }

    public static Point of(Position position, boolean bridge) {
        return new Point(position, bridge);
    }

    public Position moved(List<Point> points) {
        if (movableLeft()) {
            return position.movedBackward();
        }

        if (movableRight(points)) {
            return position.movedForward();
        }
        return position;
    }

    private boolean movableLeft() {
        if (position.isFirst()) {
            return false;
        }
        return bridge;
    }

    private boolean movableRight(List<Point> points) {
        if (position.isMaxPosition(points.size() - 1)) {
            return false;
        }

        Point nextPoint = points.get(position.forward());
        return !bridge && nextPoint.bridge;
    }

    public boolean overlapped(Point nextPoint) {
        return bridge && Point.of(this.position.movedForward(), this.bridge).equals(nextPoint);
    }

    public boolean hasBridge() {
        return bridge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return bridge == point.bridge && Objects.equals(position, point.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, bridge);
    }

    @Override
    public String toString() {
        return "Point{" +
                "position=" + position +
                ", bridge=" + bridge +
                '}';
    }
}
