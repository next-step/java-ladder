package ladder.domain;

import ladder.constant.Direction;
import ladder.constant.Type;
import ladder.exception.InvalidBoundPositionException;
import ladder.exception.NotChangeException;

import java.util.Objects;

public class Position {

    public static final int MIN_VALUE = 0;
    private static final int LEFT_POSITION_VALUE = 1;
    private static final String MESSAGE_NOT_CHANGE_FIXED = "고정된 Position 이여서 변경할 수 없습니다.";

    private final int maxValue;
    private int value;
    private Type type;

    public Position(int maxValue, int value, Type type) {
        this.maxValue = maxValue;

        if(outOfBound(value)) {
            throw new InvalidBoundPositionException(maxValue);
        }
        this.value = value;
        this.type = type;
    }

    private boolean outOfBound(int value) {
        return value < MIN_VALUE || value > maxValue;
    }

    public boolean minimum() {
        return value == MIN_VALUE;
    }

    public void change(Direction direction) {
        if (fixed()) {
            throw new NotChangeException(MESSAGE_NOT_CHANGE_FIXED);
        }
        if (invalidChangeStatus(direction)) {
            throw new NotChangeException(maxValue, value);
        }
        value += direction.value();
    }

    private boolean invalidChangeStatus(Direction direction) {
        return (direction.isLeft() && minimum()) || (direction.isRight() && maximum());
    }

    public boolean maximum() {
        return value == maxValue;
    }

    public int leftValue() {
        return value - LEFT_POSITION_VALUE;
    }

    public int value() {
        return value;
    }

    private boolean fixed() {
        return type.fixed();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return maxValue == position.maxValue && value == position.value && type == position.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxValue, value, type);
    }
}
