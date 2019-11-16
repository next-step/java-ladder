package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
    private Direction direction;
    private int index;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point firstIndex() {
        return new Point(0, Direction.getRandomDirection());
    }

    public Point next(int lastIndex) {
        int nextIndex = index + 1;
        return new Point(nextIndex, direction.next(isNextLastIndex(lastIndex)));
    }

    private boolean isNextLastIndex(int lastIndex) {
        return index + 1 == lastIndex;
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
                direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, index);
    }
}
