package ladder.domain;

import java.util.Objects;

public class Position {
    private final int value;

    public Position(int position) {
        value = position;
    }

    public Position moveLeft() {
        return new Position(value - 1);
    }

    public Position moveRight() {
        return new Position(value + 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

}
