package ladder.model;

import java.util.Objects;

public class Point {
    private final Position position;
    private final Direction direction;

    public Point(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Point(int position, Direction direction) {
        this(new Position(position), direction);
    }

    public Point(int position, boolean left, boolean right) {
        this(new Position(position), new Direction(left, right));
    }

    public static Point createFirst(boolean right) {
        return new Point(0, Direction.createFirst(right));
    }

    public Point createNext(boolean right) {
        return new Point(this.position.right(), this.direction.createNext(right));
    }

    public Point createLast() {
        return new Point(this.position.right(), this.direction.createLast());
    }

    public int move() {
        if (direction.hasLeft()) {
            return position.left();
        }
        if (direction.hasRight()) {
            return position.right();
        }
        return position.getPosition();
    }

    public boolean isRightNextDirection(Point point) {
        return this.direction.hasRight() == point.getLeft();
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

    public boolean getLeft() {
        return this.direction.hasLeft();
    }
}
