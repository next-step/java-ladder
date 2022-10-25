package ladder.domain;

import ladder.domain.exception.LessThanZeroNumberException;
import ladder.domain.exception.NonNumericStringException;

import java.util.Objects;

public class Position {

    private final int value;

    public Position() {
        this.value = 0;
    }

    public Position(final int value) {
        validateMin(value);
        this.value = value;
    }

    public Position(final String value) {
        this(parseInt(value));
    }

    private void validateMin(int value) {
        if (value < 0) {
            throw LessThanZeroNumberException.getInstance();
        }
    }

    private static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw NonNumericStringException.getInstance();
        }
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
