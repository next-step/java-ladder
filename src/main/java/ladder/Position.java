package ladder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Position {
    public static final int MAX_CACHE_VALUE = 20;
    private static final Map<Integer, Position> positions = new HashMap<>();

    static {
        for (int i = 0; i < MAX_CACHE_VALUE; i++) {
            positions.put(i, new Position(i));
        }
    }

    private final int value;

    private Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    static Position of(int value) {
        Position position = positions.get(value);
        if (position != null) {
            return position;
        }

        Position newPosition = new Position(value);
        positions.put(value, newPosition);
        return newPosition;
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
