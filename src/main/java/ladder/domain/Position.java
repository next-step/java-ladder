package ladder.domain;

import ladder.exception.InvalidBoundPositionException;
import ladder.exception.NotMoveException;

import java.util.Objects;

public class Position {

    public static final int MIN_VALUE = 0;

    private final int maxValue;
    private int value;

    public Position(int maxValue, int value) {
        this.maxValue = maxValue;

        if(outOfBound(value)) {
            throw new InvalidBoundPositionException(maxValue);
        }
        this.value = value;
    }

    private boolean outOfBound(int value) {
        return value < MIN_VALUE || value > maxValue;
    }

    public void down() {
        if (minimum()) {
            throw new NotMoveException(maxValue, value);
        }
        value--;
    }

    private boolean minimum() {
        return value == MIN_VALUE;
    }

    public void up() {
        if (maximum()) {
            throw new NotMoveException(maxValue, value);
        }
        value++;
    }

    private boolean maximum() {
        return value == maxValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return maxValue == position.maxValue && value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxValue, value);
    }
}
