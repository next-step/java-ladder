package ladder;

import java.util.Objects;

public class Position {
    private static final int ZERO = 0;
    private static final int DISTANCE = 1;
    private final int value;

    public Position(int value) {
        if (value < ZERO) {
            throw new IllegalArgumentException("위치는 " + ZERO + "보다 작을 수 없습니다.");
        }
        this.value = value;
    }

    public Position right() {
        return new Position(value - DISTANCE);
    }

    public Position left() {
        return new Position(value + DISTANCE);
    }

    public boolean isGreaterThanZero() {
        return value > ZERO;
    }

    public boolean isLessThan(int other) {
        return value < other;
    }

    public int getPosition() {
        return value;
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
        return Objects.hashCode(value);
    }
}
