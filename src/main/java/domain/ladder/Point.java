package domain.ladder;

import java.util.Objects;

public class Point {

    private static final int START_POINT = 0;

    private int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(Boolean right) {
        return new Point(START_POINT, Direction.first(right));
    }

    public int move() {
        if(direction.isLeft()){
            --this.index;
        }

        if(direction.isRight()){
            ++this.index;
        }

        return this.index;
    }


    public Point next(Boolean right) {
        return new Point(++index, direction.next(right));
    }

    public Point next() {
        return new Point(++index, direction.next());
    }

    public Point last() {
        return new Point(++index, direction.last());
    }

    public Direction getDirection() {
        return direction;
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

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}
