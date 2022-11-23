package ladder.domain;

import java.util.Objects;

public class PositiveInt {

    private final static String ERROR_NEGATIVE_VALUE = "0 이상의 값만 입력 가능합니다.";

    private final int value;

    public PositiveInt(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_VALUE);
        }
    }

    public PositiveInt plus(final int value) {
        if (value == 0) {
            return this;
        }

        return new PositiveInt(this.value + value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof PositiveInt)) {
            return false;
        }

        return this.value == ((PositiveInt) o).value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
