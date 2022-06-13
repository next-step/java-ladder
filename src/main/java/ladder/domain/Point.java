package ladder.domain;

import java.util.Objects;

public class Point {
    private int index;
    private Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean right) {
        return new Point(0, Direction.first(right));
    }

    public int move() {
        if (direction.isRight()) {
            return this.index + 1;
        }

        if (direction.isLeft()) {
            return this.index - 1;
        }

        return this.index;
    }

    public Point next(boolean right) {
        return new Point(this.index + 1, direction.next(right));
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public boolean untilBeforeLastPoint(int sizeOfPerson) {
        return sizeOfPerson - 2 > index;
    }

    public void draw() {
        if (this.direction.isRight()) {
            System.out.print("|-----|");
            return;
        }

        System.out.print("|     |");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && Objects.equals(direction, point.direction);
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
