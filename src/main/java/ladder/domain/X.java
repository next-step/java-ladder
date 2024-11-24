package ladder.domain;

import ladder.exception.NotAllowedNegativeNumber;

import java.util.Objects;

public class X {

    public static final String NOT_ALLOWED_NEGATIVE_NUMBER_MESSAGE = "좌표에 음수는 입력될 수 없습니다.";
    public static final int MINIMAL_VALUE = 0;
    private final int value;

    public X(int value) {
        validate(value);
        this.value = value;
    }

    private static void validate(int value) {
        if (value < MINIMAL_VALUE) {
            throw new NotAllowedNegativeNumber(NOT_ALLOWED_NEGATIVE_NUMBER_MESSAGE);
        }
    }

    public X() {
        this(MINIMAL_VALUE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        X x = (X) o;
        return value == x.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
