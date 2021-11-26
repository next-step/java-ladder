package nextstep.ladder.domain;

import java.util.Objects;

import static nextstep.ladder.domain.Direction.LEFT;
import static nextstep.ladder.utils.Validator.checkNotNull;

public class Position {

    public static final String NOT_LESS_THAN_ERROR_MESSAGE = " 보다 작지 않습니다.";
    public static final String NEGATIVE_ERROR_MESSAGE = "음수는 불가능합니다";
    private static final int MIN_VALUE = 0;
    private static final int VALUE_UNIT = 1;

    private final int value;

    public Position(int value) {
        checkNotNegative(value);
        this.value = value;
    }

    private void checkNotNegative(int position) {
        if (position < MIN_VALUE) {
            throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
        }
    }

    public Position move(Direction direction) {
        checkNotNull(direction);
        if (direction == LEFT) {
            return left();
        }
        return right();
    }

    private Position left() {
        return new Position(value - VALUE_UNIT);
    }

    private Position right() {
        return new Position(value + VALUE_UNIT);
    }

    public int leftValue() {
        return value - VALUE_UNIT;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public void checkLessThan(int other) {
        if (value >= other) {
            throw new IllegalArgumentException(other + NOT_LESS_THAN_ERROR_MESSAGE);
        }
    }
}
