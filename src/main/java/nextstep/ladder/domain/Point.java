package nextstep.ladder.domain;

import java.util.Objects;

public class Point {

    private final int index;
    private final Movement movement;

    public Point(final int index, final Movement movement) {

        this.index = index;
        this.movement = movement;
    }

    public static Point first(final Movement first) {

        return new Point(0, first);
    }

    public int move() {

        if (this.movement.move() == Direction.RIGHT) {
            return this.index + 1;
        }
        if (this.movement.move() == Direction.LEFT) {
            return this.index - 1;
        }
        return this.index;
    }

    public Point next(final boolean generate) {

        final int index = this.index + 1;
        return new Point(index, this.movement.next(generate));
    }

    public int getIndex() {

        return this.index;
    }

    public Movement getMovement() {

        return this.movement;
    }

    public boolean untilExcludeStart(final int size, final int countOfPerson) {

        return size < countOfPerson - 1;
    }

    public boolean duplicate() {

        return this.movement.duplicate();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && Objects.equals(movement, point.movement);
    }

    @Override
    public int hashCode() {

        return Objects.hash(index, movement);
    }
}
