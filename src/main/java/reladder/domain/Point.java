package reladder.domain;

import java.util.Objects;

public class Point {

    private static final int NEXT_DISTANCE = 1;
    private static final int FIRST_DISTANCE = 0;

    private int index;
    private Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        Director director = Director.of(direction);
        return director.move(index);
    }

    public static Point firstNext(boolean next) {
        return new Point(FIRST_DISTANCE, Direction.first(next));
    }

    public Point lastNext() {
        return new Point(index + NEXT_DISTANCE, direction.last());
    }

    public Point next(boolean next) {
        return new Point(index + NEXT_DISTANCE, direction.next(next));
    }

    public boolean isPrintLadderPoint() {
        return !direction.isLeft() && direction.isRight();
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
