package ladder.domain;

import java.util.Objects;

public class Position {
    private static final int CHANGING_UNIT = 1;
    private final int value;

    public Position(int value) {
        if (value < 0) {
            throw new IllegalStateException("Postion 은 음수 일 수 없습니다.");
        }
        this.value = value;
    }

    public Position right() {
        return new Position(value + CHANGING_UNIT);
    }

    public Position left() {
        return new Position(value - CHANGING_UNIT);
    }

    public int toInt() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
