package laddergame.domain;

import java.util.Objects;

public class LadderHeight {

    private static final int MIN_VALUE = 1;

    private final int value;

    public LadderHeight(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이여야 합니다.");
        }
    }

    public int getValue() {
        return value;
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

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
