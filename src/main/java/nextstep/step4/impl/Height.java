package nextstep.step4.impl;

import java.util.Objects;

public class Height {
    public static final int ZERO_NUMBER = 0;
    public static final String NEGATIVE_NUMBER_MSG = "높이는 음수 일수 없습니다.";
    private final int value;

    public Height(final int height) {
        negativeHeightCheck(height);
        this.value = height;
    }

    private void negativeHeightCheck(final int height) {
        if (height < ZERO_NUMBER) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_MSG);
        }
    }

    public int get() {
        return this.value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Height height1 = (Height) o;
        return value == height1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
