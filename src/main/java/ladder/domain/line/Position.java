package ladder.domain.line;

import java.util.Objects;

public class Position {

    private static final int MIN_VALUE = 0;
    private static final int MOVE_VALUE = 1;

    private final int value;

    private Position(int value) {
        if (isInvalidRange(value)) {
            throw new IllegalArgumentException(String.format("포지션은 %d이상 입력 할 수 있습니다.", MIN_VALUE));
        }

        this.value = value;
    }

    private boolean isInvalidRange(int value) {
        return value < 0;
    }

    public static Position valueOf(int position) {
        return new Position(position);
    }

    public int getValue() {
        return value;
    }

    public Position left() {
        return Position.valueOf(value - MOVE_VALUE);
    }

    public Position right() {
        return Position.valueOf(value + MOVE_VALUE);
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
