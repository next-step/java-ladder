package ladder.domain.ladder;

import java.util.Objects;

public class Position {
    private final int value;

    public Position(int value) {
        if (value < 0) {
            throw new IllegalStateException("Position 은 음수 일 수 없습니다.");
        }
        this.value = value;
    }

    public Position right() {
        return new Position(value + 1);
    }

    public Position left() {
        return new Position(value - 1);
    }

    public int getValue() {
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

    @Override
    public String toString() {
        return "" + value;
    }
}
