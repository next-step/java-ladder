package domain;

import java.util.Objects;

class Point {

    private static final String EXIST = "-----|";
    private static final String NOT_EXIST = "     |";

    private final int index;
    private final Direction direction;

    Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    static Point first(boolean canMake) {
        return new Point(0, Direction.first(canMake));
    }

    Point next(boolean canMake) {
        return new Point(index + 1, direction.next(canMake));
    }

    Point last() {
        return new Point(index + 1, direction.last());
    }

    boolean canMoveLeft() {
        return direction.isLeft();
    }

    boolean canMoveRight() {
        return direction.isRight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index &&
            direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }

    @Override
    public String toString() {
        return direction.isLeft() ? EXIST : NOT_EXIST;
    }
}
