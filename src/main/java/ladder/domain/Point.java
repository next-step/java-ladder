package ladder.domain;

import java.util.Objects;

public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int next() {
        return direction.nextIndex(this.index);
    }

    public boolean isEqualIndex(int index) {
        return this.index == index;
    }

    public boolean isDirection(Direction direction) {
        return this.direction.equals(direction);
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
}
