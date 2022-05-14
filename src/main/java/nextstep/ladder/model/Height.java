package nextstep.ladder.model;

import java.util.Objects;

public final class Height {

    private static final String EMPTY_EXCEPTION_MESSAGE = "사다리의 높이는 1보다 작을 수 없습니다. (입력받은 사다리 높이:%d)";
    private static final int LEAST_HEIGHT_SIZE = 1;

    private final int value;

    public Height(int value) {
        validate(value);
        this.value = value;
    }

    public void validate(int value) {
        if (value < LEAST_HEIGHT_SIZE) {
            throw new NullPointerException(String.format(EMPTY_EXCEPTION_MESSAGE, value));
        }
    }

    public int value() {
        return value;
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
