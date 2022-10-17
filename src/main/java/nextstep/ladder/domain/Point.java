package nextstep.ladder.domain;

import java.util.Objects;

public class Point {

    private final int index;
    private final Direction direction;

    public Point(final int index, final Direction direction) {

        this.index = index;
        this.direction = direction;
    }

    public static Point first(final boolean right) {

        return new Point(0, Direction.of(false, right));
    }

    public boolean duplicate() {

        return this.direction.duplicate();
    }

    public int move() {

        if (this.direction == Direction.RIGHT) {
            return this.index + 1;
        }
        if (this.direction == Direction.LEFT) {
            return this.index - 1;
        }
        return this.index;
    }

    public Point next(final boolean generate) {

        final int index = this.index + 1;
        return new Point(index, this.direction.next(generate));
    }

    public int getIndex() {

        return this.index;
    }

    public Direction getDirection() {

        return this.direction;
    }

    public boolean untilExcludeStart(final int size, final int countOfPerson) {

        return size < countOfPerson - 1;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && direction == point.direction;
    }

    @Override
    public int hashCode() {

        return Objects.hash(index, direction);
    }
}
