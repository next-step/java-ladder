package reladder;

import java.util.Objects;

public class Point {

    private static final int DISTANCE = 1;

    private int index;
    private Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
//        return this.index + Director.getIndex(this.direction);
        if (this.direction.isLeft()) {
            return index - DISTANCE;
        }

        if (this.direction.isRight()) {
            return index + DISTANCE;
        }

        return this.index;
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
