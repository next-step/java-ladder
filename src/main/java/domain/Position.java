package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {
    private static final Map<Integer, Position> POSITION_MAP = new HashMap<>() {{
        for (int i = 1; i <= 20; i++) {
            put(i, new Position(i));
        }
    }};

    private final int value;
    public static Position valueOf(int value) {
        return POSITION_MAP.getOrDefault(value, new Position(value));
    }

    public Position(int value) {
        this.value = value;
    }

    public boolean hasPosition(int target) {
        return value == target;
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

    public int getPosition() {
        return value;
    }

    public Position move(PointDirection pointDirection) {
        return Position.valueOf(pointDirection.operate(value));
    }
}
