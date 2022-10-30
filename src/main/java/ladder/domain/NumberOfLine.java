package ladder.domain;

import ladder.domain.exception.LessThanMinimumNumberException;
import ladder.domain.exception.NonNumericStringException;

import java.util.Objects;

public class NumberOfLine {

    public static final int MINIMUM = 1;

    private final int value;

    public NumberOfLine(final int value) {
        validateMin(value);
        this.value = value;
    }

    public NumberOfLine(final String value) {
        this(parseInt(value));
    }

    private void validateMin(int value) {
        if (value < MINIMUM) {
            throw new LessThanMinimumNumberException(MINIMUM);
        }
    }

    private static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw NonNumericStringException.getInstance();
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberOfLine that = (NumberOfLine) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "NumberOfPlayer{" +
                "value=" + value +
                '}';
    }
}
