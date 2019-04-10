package ladder.vo;

import java.util.Objects;

public class Length {
    private static final int MIN_LENGTH = 1;

    private final int value;

    public Length(int value) {
        validateValue(value);

        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEqualValue(int value){
        return this.value == value;
    }

    private void validateValue(int value) {
        if (value < MIN_LENGTH) {
            throw new IllegalArgumentException("Length must be larger than " + MIN_LENGTH);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return value == length.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
