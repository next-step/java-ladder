package ladder.domain;

import ladder.exception.NotAllowedNegativeNumber;

import java.util.Objects;

import static ladder.exception.NotAllowedNegativeNumber.NOT_ALLOWED_NEGATIVE_NUMBER_MESSAGE;

public class Y {
    public static final int MINIMAL_VALUE = 0;
    public static final int MOVE = 1;
    private final int value;

    public Y(int value) {
        validate(value);
        this.value = value;
    }

    public Y() {
        this(MINIMAL_VALUE);
    }

    private static void validate(int value) {
        if (value < MINIMAL_VALUE) {
            throw new NotAllowedNegativeNumber(NOT_ALLOWED_NEGATIVE_NUMBER_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Y y = (Y) o;
        return value == y.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Y moveDown() {
        return new Y(value + MOVE);
    }
}
