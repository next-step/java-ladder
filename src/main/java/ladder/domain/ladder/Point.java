package ladder.domain.ladder;

import java.util.Objects;

public class Point {

    private final PointPosition position;
    private final PointDirection direction;

    private Point(int position, PointDirection direction) {
        this.position = new PointPosition(position);
        this.direction = direction;
    }

    public static Point of(int position, PointDirection direction) {
        return new Point(position, direction);
    }

    public static Point first(boolean current) {
        return Point.of(0, PointDirection.first(false, current));
    }

    public static Point middle(Point point, boolean current) {
        return Point.of(point.getPosition() + 1, PointDirection.next(point.getDirection(), current));
    }

    public static Point last(Point point) {
        return Point.of(point.getPosition() + 1, PointDirection.next(point.getDirection(), false));
    }

    public int move() {
        if (isRight()) {
            return position.increment();
        }
        if (isLeft()) {
            return position.decrement();
        }
        return position.stop();
    }

    public boolean isRight() {
        return direction.isRight();
    }

    public boolean isLeft() {
        return direction.isLeft();
    }

    public int getPosition() {
        return position.getPosition();
    }

    private PointDirection getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return Objects.equals(position, point.position) && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }

    @Override
    public String toString() {
        return "position=" + position +
                        " " + direction;
    }

}

