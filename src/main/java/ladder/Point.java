package ladder;

import java.util.Objects;

public class Point {
    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point of(int index, Direction direction) {
        return new Point(index, direction);
    }

    public Point next(PointMaker pointMaker) {
        return of(index + 1, direction.next(pointMaker));
    }

    public Point next(Boolean right) {
        return of(index + 1, direction.next(right));
    }

    public Point last() {
        return of(index + 1, direction.last());
    }

    public static Point first(PointMaker pointMaker) {
        return of(0, Direction.first(pointMaker.nextBoolean()));
    }

    public String getLine(){
        return this.direction.getLine();
    }

    public int getIndex() {
        return index;
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
