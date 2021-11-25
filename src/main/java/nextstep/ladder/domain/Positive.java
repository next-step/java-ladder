package nextstep.ladder.domain;

import java.util.Objects;

public class Positive {

    public static final String NOT_POSITIVE_ERROR_MESSAGE = "양수가 아닙니다.";
    private static final int MIN_VALUE = 1;

    private final int value;

    public Positive(int value) {
        checkPositive(value);
        this.value = value;
    }

    private void checkPositive(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positive positive = (Positive) o;
        return value == positive.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Positive{" +
                "value=" + value +
                '}';
    }
}
