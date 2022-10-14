package ladder.domain.line.v2;


import ladder.domain.position.Position;

import java.util.Objects;

public class Point {
    private final Position position;
    private final Direction direction;

    Point(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point first(boolean hasRight) {
        return new Point(new Position(0), Direction.first(hasRight));
    }

    public Point next(boolean hasRight) {
        return new Point(position.moveRight(), direction.next(hasRight));
    }

    public Point last() {
        return new Point(position.moveRight(), direction.last());
    }

    public Position move() {
        if (direction.isRight()) {
            return position.moveRight();
        }

        if (direction.isLeft()) {
            return position.moveLeft();
        }

        return position;
    }

    public Boolean hasRight() {
        return direction.isRight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (!Objects.equals(position, point.position)) return false;
        return direction == point.direction;
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }
}
