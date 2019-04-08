package ladder.vo.coordinate;

import java.util.Objects;

public class CoordinateValue {
    private static final int MIN_COORDINATE_VALUE = 0;

    private final int value;

    public CoordinateValue(int value) {
        validateInitialValue(value);

        this.value = value;
    }

    private void validateInitialValue(int value) {
        if (isNotValidValue(value)) {
            throw new IllegalArgumentException("Coordinate value must be at least " + MIN_COORDINATE_VALUE);
        }
    }

    private boolean isNotValidValue(int value) {
        return value < MIN_COORDINATE_VALUE;
    }

    public int getValue() {
        return value;
    }

    public CoordinateValue increment() {
        return new CoordinateValue(this.value + 1);
    }

    public CoordinateValue decrement() {
        int decrementedValue = this.value - 1;
        validationDecrementValue(decrementedValue);

        return new CoordinateValue(decrementedValue);
    }

    private void validationDecrementValue(int decrementedValue) {
        if (isNotValidValue(decrementedValue)) {
            throw new IllegalStateException("It can't be decreased");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateValue that = (CoordinateValue) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
