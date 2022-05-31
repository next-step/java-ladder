package ladder.domain;

import ladder.constant.Direction;
import ladder.exception.InvalidBoundIndexException;
import ladder.exception.NotChangeException;

import java.util.Objects;

public class Index {

    public static final int MIN_VALUE = 0;

    private final int maxValue;
    private int value;

    public Index(int maxValue, int value) {
        this.maxValue = maxValue;

        if(isOutOfBound(value)) {
            throw new InvalidBoundIndexException(maxValue);
        }
        this.value = value;
    }

    private boolean isOutOfBound(int value) {
        return value < MIN_VALUE || value > maxValue;
    }

    public void change(Direction direction) {
        if (invalidChangeStatus(direction)) {
            throw new NotChangeException(maxValue, value);
        }
        value += direction.value();
    }

    private boolean invalidChangeStatus(Direction direction) {
        return (direction.isLeft() && isMinimum()) || (direction.isRight() && isMaximum());
    }

    private boolean isMinimum() {
        return value == MIN_VALUE;
    }

    private boolean isMaximum() {
        return value == maxValue;
    }

    public int toInt() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index = (Index) o;
        return maxValue == index.maxValue && value == index.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxValue, value);
    }
}
