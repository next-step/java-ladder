package ladder.domain;

import java.util.Objects;

public class PositiveInt {

    private final static String ERROR_NEGATIVE_VALUE = "0 이상의 값만 입력 가능합니다.";
    private final static String ERROR_IMPOSSIBLE_TO_CALCULATE = "계산을 할 수 없습니다.";
    private final static PositiveInt ZERO = new PositiveInt(0);

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

    public static PositiveInt zero() {
        return ZERO;
    }

    public PositiveInt plus(final int i) {
        return new PositiveInt(value + i);
    }

    public PositiveInt minus(final int i) {
        if (value < i) {
            throw new IllegalArgumentException(ERROR_IMPOSSIBLE_TO_CALCULATE);
        }

        return new PositiveInt(value - i);
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
