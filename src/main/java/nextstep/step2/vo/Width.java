package nextstep.step2.vo;

import java.util.Objects;

public class Width {
    private static final int MIN = 2;
    private static final String NULL_OR_LESS_HEIGHT_MESSAGE = "넓이 값은 " + MIN + " 이상 이어야 합니다.";

    private final int value;

    private Width(int value) {
        if (value < MIN) {
            throw new IllegalArgumentException(NULL_OR_LESS_HEIGHT_MESSAGE);
        }
        this.value = value;
    }

    public static Width of(int value) {
        return new Width(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Width width = (Width) o;
        return value == width.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
