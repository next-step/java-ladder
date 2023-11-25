package ladder.domain;

import java.util.Objects;

public class Coordinate {
    private static final Coordinate POSITIVE = new Coordinate(true);
    private static final Coordinate NEGATIVE = new Coordinate(false);

    private final boolean state;

    public Coordinate(boolean state) {
        this.state = state;
    }

    public static Coordinate valueOf(boolean state) {
        if (state) {
            return POSITIVE;
        }
        return NEGATIVE;
    }

    public Coordinate next(boolean state) {
        if (this.state) {
            return NEGATIVE;
        }
        return Coordinate.valueOf(state);

    }

    public boolean exist() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return state == that.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }

    @Override
    public String toString() {
        return String.valueOf(state);
    }
}
