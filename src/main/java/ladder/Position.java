package ladder;

import java.util.Objects;

public class Position {
    private static final int ZERO = 0;
    public static final int ONE = 1;
    private final int value;

    public Position(int value) {
        if (value < ZERO) {
            throw new IllegalArgumentException("위치는 " + ZERO + "보다 작을 수 없습니다.");
        }
        this.value = value;
    }

    public Position decrease() {
        return new Position(value - ONE);
    }

    public Position increase() {
        return new Position(value + ONE);
    }

    public boolean isGreaterThanZero() {
        return value > ZERO;
    }

    public boolean isLessThan(int oterh) {
        return value < oterh;
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
