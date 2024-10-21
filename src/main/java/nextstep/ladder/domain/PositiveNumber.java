package nextstep.ladder.domain;

import java.util.Objects;

public class PositiveNumber {
    public static final int MINIMUM_NUMBER = 1;

    private final int value;

    public PositiveNumber(int number) {
        if (number < MINIMUM_NUMBER) {
            throw new IllegalArgumentException("0 이하일 수 없습니다.");
        }
        this.value = number;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber that = (PositiveNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
