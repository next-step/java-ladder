package ladder.domain;

import java.util.Objects;

public class Position {
    public static final int DEFAULT_MOVEMENT_POSITION = 1;

    private final int position;

    public Position(final int position) {
        this.position = position;
    }

    public int value() {
        return position;
    }

    Position left() {
        return new Position(position - DEFAULT_MOVEMENT_POSITION);
    }

    Position right() {
        return new Position(position + DEFAULT_MOVEMENT_POSITION);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
