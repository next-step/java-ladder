package refactoring.domain;

import static refactoring.domain.LineStatus.CONNECTION;
import static refactoring.domain.LineStatus.DETACHMENT;

import java.util.Objects;

public class Direction {


    private final LineStatus before;
    private final LineStatus current;

    public Direction(final LineStatus before, final LineStatus current) {

        this.before = before;
        this.current = current;
    }

    public Direction last() {
        return new Direction(current, DETACHMENT);
    }

    public static Direction first(final LineStatus current) {
        return new Direction(DETACHMENT, current);
    }

    public static Direction of(final LineStatus before, final LineStatus current) {
        return new Direction(before, current);
    }

    public Direction next() {
        return this.current == CONNECTION
            ? new Direction(this.current, DETACHMENT)
            : new Direction(this.current, LineStatus.generate());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Direction direction = (Direction) o;
        return before == direction.before && current == direction.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(before, current);
    }

    public int move() {
        return Movement.next(before, current);
    }
}
