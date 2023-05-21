package nextstep.ladder.domain;

import java.util.Objects;

public class Position {
    private final int value;

    public Position(int value) {
        this.value = value;
    }

    public static Position from(int value) {
        return new Position(value);
    }

    public int toInt() {
        return value;
    }

    public Position move(Line line) {
        if (line.canMoveOnRight(value)) {
            return new Position(value + 1);
        }
        if (line.canMoveOnLeft(value)) {
            return new Position(value - 1);
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
