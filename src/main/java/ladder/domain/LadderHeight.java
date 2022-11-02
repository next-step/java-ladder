package ladder.domain;

import ladder.exception.InvalidLadderHeightException;

import java.util.Objects;

public class LadderHeight {

    private final int value;

    public LadderHeight(final int value) {
        validateOrThrow(value);

        this.value = value;
    }

    private void validateOrThrow(final int value) {
        if (value <= 0) {
            throw new InvalidLadderHeightException();
        }
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderHeight that = (LadderHeight) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
