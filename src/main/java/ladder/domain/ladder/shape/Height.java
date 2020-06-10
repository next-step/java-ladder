package ladder.domain.ladder.shape;

import ladder.exception.ErrorMessage;
import ladder.exception.ValueOutOfBoundsException;

import java.util.Objects;

public class Height {

    public static final int MIN_HEIGHT = 1;

    private final int value;

    private Height(final int value) {
        verifyHeight(value);
        this.value = value;
    }

    public static Height of(final int value) {
        return new Height(value);
    }

    private static void verifyHeight(final int height) {
        if (height < MIN_HEIGHT) {
            throw new ValueOutOfBoundsException(ErrorMessage.REQUIRED_MIN_LADDER_HEIGHT);
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Height)) return false;
        Height height = (Height) o;
        return value == height.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
