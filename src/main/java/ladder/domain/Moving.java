package ladder.domain;

import java.util.Objects;

public class Moving {

    private boolean previous;
    private boolean current;

    public Moving(boolean previous, boolean current) {
        this.previous = previous;
        this.current = current;
    }

    public static Moving right() {
        return new Moving(false, true);
    }

    public static Moving stay() {
        return new Moving(false, false);
    }

    public static Moving left() {
        return new Moving(true, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Moving moving = (Moving) o;
        return previous == moving.previous &&
                current == moving.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(previous, current);
    }

}
