package ladder;

import java.util.Objects;

class Position {
    private final int value;

    private Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    static Position of(int value) {
        return new Position(value);
    }

    int getValue() {
        return value;
    }

    boolean isFirst() {
        return this.value == 0;
    }

    Position increment() {
        return new Position(this.value + 1);
    }

    Position decrement() {
        return new Position(this.value - 1);
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

    @Override
    public String toString() {
        return "Position{" +
                "value=" + value +
                '}';
    }
}
