package nextstep.ladder.domain;

import java.util.Objects;

public class Position {
    private final int value;

    public Position(int value) {
        this.value = value;
    }

    public static Position of(int position) {
        if (position < 0) {
            throw new OutOfLineException();
        }
        return new Position(position);
    }

    public int toInt() {
        return value;
    }

    public boolean isEqualsValue(int value) {
        return this.value == value;
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
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Position{" +
               "value=" + value +
               '}';
    }

    public Position move(int direction) {
        return of(value + direction);
    }
}
