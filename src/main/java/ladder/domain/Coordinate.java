package ladder.domain;

import java.util.Objects;

public class Coordinate {

    private final Position x;
    private final Position y;

    public Coordinate(final Position x,final Position y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate(final int x, final int y) {
        this(new Position(x), new Position(y));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
