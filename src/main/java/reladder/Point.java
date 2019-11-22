package reladder;

import java.util.Objects;

public class Point {

    private int index;
    private Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        return this.index + Director.getIndex(this.direction);
    }

    public static Point firstNext(boolean next) {
        return new Point(0, Direction.first(next));
    }

    public Point lastNext() {
        return new Point(move(), this.direction.last());
    }

    public Point next() {
        return new Point(move(), this.direction.next());
    }

    public Point next(boolean next) {
        return new Point(move(), this.direction.next(next));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index &&
                Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }
}
