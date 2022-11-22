package ladder.domain;

import java.util.Objects;

public class Point {
    private static final Integer INIT_POINT_INDEX = 0;

    private final Direction direction;
    private final Integer index;

    private Point(Direction direction, Integer index) {
        this.direction = direction;
        this.index = index;
    }

    public static Point first(boolean right) {
        return new Point(Direction.first(right), INIT_POINT_INDEX);
    }

    public Point next(boolean right) {
        return new Point(this.direction.next(right), this.index + 1);
    }

    public Point last() {
        return new Point(this.direction.last(), this.index + 1);
    }

    public Boolean getCurrent() {
        return this.direction.isRight();
    }

    public int nextIndex() {
        if (this.direction.isRight()) {
            return this.index + 1;
        }
        if (this.direction.isLeft()) {
            return this.index - 1;
        }
        return this.index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(direction, point.direction) && Objects.equals(index, point.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, index);
    }
}
