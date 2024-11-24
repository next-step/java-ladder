package ladder.domain;

import ladder.exception.NotAllowedNegativeNumber;

import java.util.Objects;

import static ladder.exception.NotAllowedNegativeNumber.NOT_ALLOWED_NEGATIVE_NUMBER_MESSAGE;

public class X {

    public static final int MINIMAL_VALUE = 0;
    public static final int MOVE = 1;
    private final int value;

    public X(int value) {
        validate(value);
        this.value = value;
    }

    private static void validate(int value) {
        if (value < MINIMAL_VALUE) {
            throw new NotAllowedNegativeNumber(NOT_ALLOWED_NEGATIVE_NUMBER_MESSAGE);
        }
    }

    public X() {
        this(MINIMAL_VALUE);
    }

    public X moveRight() {
        return new X(value + MOVE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        X x = (X) o;
        return value == x.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public X moveLeft() {
        return new X(value - MOVE);
    }
}
