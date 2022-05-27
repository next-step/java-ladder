package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.Position;
import nextstep.ladder.util.ConnectStrategy;

import java.util.Objects;

public class Point {

    private final Position position;
    private final Direction direction;

    private Point(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point of(Position position, Direction direction) {
        return new Point(position, direction);
    }

    public static Point first(ConnectStrategy connectStrategy) {
        return new Point(Position.first(), Direction.first(connectStrategy));
    }

    public Point next(ConnectStrategy connectStrategy) {
        return new Point(position.next(), direction.next(connectStrategy));
    }

    public Point last() {
        return new Point(position.next(), direction.last());
    }

    public Position move() {
        if (direction.isLeft()) {
            return position.before();
        }

        if (direction.isRight()) {
            return position.next();
        }

        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(position, point.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        if (direction.isRight()) {
            return "|-----";
        }
        return "|     ";
    }
}
