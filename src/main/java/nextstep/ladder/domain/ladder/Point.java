package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Point {
    private final Location location;
    private final Direction direction;

    public static Point first(DirectionStrategy directionStrategy) {
        return of(Location.init(), Direction.first(directionStrategy));
    }

    public static Point of(final Location location, final Direction direction) {
        return new Point(location, direction);
    }

    private Point(final Location location, final Direction direction) {
        if (Objects.isNull(location) || Objects.isNull(direction)) {
            throw new IllegalArgumentException("Point 의 location & direction 은 null 일 수 없습니다.");
        }
        this.location = location;
        this.direction = direction;
    }

    public Point next(DirectionStrategy directionStrategy) {
        return of(location.toRight(), direction.next(directionStrategy));
    }

    public Point last() {
        return of(location.toRight(), direction.last());
    }

    public Location move() {
        return location.move(direction);
    }

    boolean isEqualLocation(final Location otherLocation) {
        return location.equals(otherLocation);
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        final Point point = (Point) o;
        return Objects.equals(location, point.location) &&
                Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, direction);
    }

    @Override
    public String toString() {
        return "Point{" +
                "location=" + location +
                ", direction=" + direction +
                '}';
    }
}
