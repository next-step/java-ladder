package nextstep.ladder.domain;

import java.util.Objects;

public final class PositiveNumber {

    public static final PositiveNumber ONE = new PositiveNumber(1);

    private final int value;

    public PositiveNumber(final int value) {
        validateValue(value);
        this.value = value;
    }

    private static void validateValue(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("value should be greater than 0");
        }
    }

    public PositiveNumber plus(final PositiveNumber positiveNumber) {
        if (positiveNumber == null) {
            return new PositiveNumber(value);
        }
        return new PositiveNumber(value + positiveNumber.value);
    }

    public boolean isGreaterThan(final PositiveNumber positiveNumber) {
        if (positiveNumber == null) {
            return false;
        }
        return value > positiveNumber.value;
    }

    public boolean isLessThanOrEquals(final PositiveNumber positiveNumber) {
        if (positiveNumber == null) {
            return false;
        }
        return value <= positiveNumber.value;
    }

    public boolean isLessThan(final PositiveNumber positiveNumber) {
        if (positiveNumber == null) {
            return false;
        }
        return value < positiveNumber.value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PositiveNumber that = (PositiveNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
