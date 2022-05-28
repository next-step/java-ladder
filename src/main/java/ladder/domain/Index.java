package ladder.domain;

import ladder.constant.Direction;
import ladder.exception.InvalidBoundIndexException;
import ladder.exception.NotChangeException;

import java.util.Objects;

public class Index {

    public static final int MIN_VALUE = 0;
    private static final int LEFT_POSITION_VALUE = 1;

    private final int maxValue;
    private int value;

    public Index(int maxValue, int value) {
        this.maxValue = maxValue;

        if(outOfBound(value)) {
            throw new InvalidBoundIndexException(maxValue);
        }
        this.value = value;
    }

    private boolean outOfBound(int value) {
        return value < MIN_VALUE || value > maxValue;
    }

    public void change(Direction direction) {
        if (invalidChangeStatus(direction)) {
            throw new NotChangeException(maxValue, value);
        }
        value += direction.value();
    }

    private boolean invalidChangeStatus(Direction direction) {
        return (direction.isLeft() && minimum()) || (direction.isRight() && maximum());
    }

    public boolean minimum() {
        return value == MIN_VALUE;
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
