package step4;

import java.util.Objects;

public class Direction {

    private final boolean before;
    private final boolean current;

    public Direction(boolean before, boolean current) {
        this.before = before;
        this.current = current;
    }

    public static Direction of(boolean before, boolean current) {
        return new Direction(before, current);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Direction direction = (Direction) o;
        return before == direction.before && current == direction.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(before, current);
    }
}
