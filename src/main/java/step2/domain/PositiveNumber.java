package step2.domain;

import java.util.Objects;

public class PositiveNumber {
    private final int number;

    private PositiveNumber(final int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public static PositiveNumber of(final int number) {
        return new PositiveNumber(number);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof PositiveNumber)) return false;
        final PositiveNumber that = (PositiveNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
