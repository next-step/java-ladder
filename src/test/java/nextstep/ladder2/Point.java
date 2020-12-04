package nextstep.ladder2;

import java.util.Objects;

class Point {
    private final int index;
    private final Direction direction;

    Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean right) {
        return new Point(0, Direction.first(right));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Point point = (Point) o;
        return index == point.index && direction.equals(point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }

    public int move() {
        if (direction.isRight()) {
            return index + 1;
        }
        if (direction.isLeft()) {
            return index - 1;
        }
        return index;
    }

    public Point next(boolean right) {
        return new Point(index + 1, direction.next(right));
    }
}
