package ladder.domain;

import java.util.Objects;

public class Point {

    static final int FIRST_INDEX = 0;
    private final Position index;
    private final Direction direction;

    private Point(Position index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point of(Position index, Direction direction) {
        return new Point(index, direction);
    }

    static Point makeFirstPoint(Direction direction) {
        return new Point(Position.from(FIRST_INDEX), direction);
    }

    Point makeNextPoint(Direction direction) {
        return new Point(index.moveToRight(), direction);
    }

    Point makeLastPoint() {
        Direction lastPointDirection = Direction.PASS;
        if (this.direction == Direction.RIGHT) {
            lastPointDirection = Direction.LEFT;
        }
        return new Point(index.moveToRight(), lastPointDirection);
    }

    Position move(Position position) {
        return direction.move(position);
    }

    boolean isDirectionRight() {
        return direction.isRight();
    }

    Position getIndex() {
        return index;
    }

    Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(index, point.index) &&
                direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}
