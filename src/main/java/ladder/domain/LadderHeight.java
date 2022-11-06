package ladder.domain;

import java.util.Objects;

public class LadderHeight {

    private final int value;

    public LadderHeight(final int value) {
        validateOrThrow(value);

        this.value = value;
    }

    private void validateOrThrow(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("유효하지 않은 사다리 높이입니다.");
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
