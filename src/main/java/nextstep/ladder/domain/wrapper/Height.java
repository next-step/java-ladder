package nextstep.ladder.domain.wrapper;


import java.util.Objects;

import static nextstep.ladder.exception.ExceptionMessage.NOT_POSITIVE;

public class Height {

    private int value;

    public Height(int value) {
        validatePositive(value);

        this.value = value;
    }

    public int value() {
        return this.value;
    }

    private void validatePositive(int val) {
        if (val <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE.message());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height = (Height) o;
        return value == height.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
