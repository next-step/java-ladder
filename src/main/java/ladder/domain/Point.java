package ladder.domain;

import java.util.Objects;

public class Point {
    private final Direction direction;
    private final Position position;

    private Point(Direction direction, Position position) {
        this.direction = direction;
        this.position = position;
    }


    public static Point create(Direction direction, int position) {
        return new Point(direction, Position.create(position));
    }

    public static Point createFirst(boolean right) {
        return Point.create(Direction.createFirst(right), 0);
    }

    public Point createNext(boolean right) {
        return Point.create(this.direction.createNext(right), this.position.moveToRight());
    }

    public Point createLast() {
        return Point.create(this.direction.createLast(), this.position.moveToRight());
    }

    public Position position() {
        return this.position;
    }

    public boolean canMoveToLeft() {
        return this.direction.canMoveToLeft();
    }

    public boolean canMoveToRight() {
        return this.direction.canMoveToRight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(direction, point.direction) && Objects.equals(position, point.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, position);
    }
}
