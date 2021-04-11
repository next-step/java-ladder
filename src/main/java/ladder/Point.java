package ladder;

import java.util.Objects;

public class Point {
    private final Position position;
    private Direction direction;

    public Point(Position position) {
        this.position = position;
    }

    public boolean isFirst() {
        return position(Position.FIRST);
    }

    public boolean isLast() {
        return position(Position.LAST);
    }

    private boolean position(Position position) {
        return this.position.equals(position);
    }

    public boolean haveRightDirection() {
        return direction.equals(Direction.RIGHT);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public PointResult toPointResult() {
        return new PointResult(position, direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(position, point.position) && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }

    @Override
    public String toString() {
        return "Point{" +
                "position=" + position +
                ", direction=" + direction +
                '}';
    }
}
