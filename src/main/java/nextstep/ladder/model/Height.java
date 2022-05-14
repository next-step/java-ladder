package nextstep.ladder.model;

import java.util.Objects;

public final class Height {

    private static final String EMPTY_EXCEPTION_MESSAGE = "사다리의 높이는 1보다 작을 수 없습니다.";
    private static final int LEAST_HEIGHT_SIZE = 1;

    private final int value;

    public Height(int value) {
        validate(value);
        this.value = value;
    }

    public void validate(int value) {
        if(value < LEAST_HEIGHT_SIZE) {
            throw new NullPointerException(EMPTY_EXCEPTION_MESSAGE);
        }
    }

    public int height() {
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
