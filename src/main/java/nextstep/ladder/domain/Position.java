package nextstep.ladder.domain;

import java.util.Objects;

public class Position {

    private static final int NEXT_ROW_NUMBER = 1;

    private final int x;
    private final int y;

    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public Position nextRowPosition() {
        return new Position(this.x, this.y + NEXT_ROW_NUMBER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
