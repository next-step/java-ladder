package nextstep.step2.vo;

import java.util.Objects;

public class Height {

    private static final int MIN_HEIGHT = 1;
    private static final String NULL_OR_LESS_HEIGHT_MESSAGE = "높이 값은 1 이상 이어야 합니다.";

    private final int value;

    private Height(int value) {
        this.value = value;
    }

    public static Height of(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_LESS_HEIGHT_MESSAGE);
        }
        return of(Integer.parseInt(input));
    }

    public static Height of(int value) {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException(NULL_OR_LESS_HEIGHT_MESSAGE);
        }

        return new Height(value);
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Height height = (Height) o;
        return value == height.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
