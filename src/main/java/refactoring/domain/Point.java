package refactoring.domain;

import java.util.Objects;

public class Point {

    private final int index;
    private final Direction direction;

    public Point(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(final LineStatus currentStatus) {
        return new Point(0, Direction.first(currentStatus));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public int move() {
        return index + direction.move();
    }

    public boolean beforeLast(final int countOfPlayer) {
        return countOfPlayer - 2 > index;
    }

    @Override
    public boolean equals(final Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Point point = (Point) o;
        return index == point.index && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }
    public LineStatus getConnection(){
        return direction.getStatus();
    }
}
