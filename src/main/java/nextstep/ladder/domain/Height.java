package nextstep.ladder.domain;

import java.util.Objects;

public class Height {

    private static final String GUIDE_ERR_HEIGHT_LESS_THAN = "높이가 1보다 작을 수는 없습니다.";
    private static final int MIN_HEIGHT = 1;

    private final int value;

    private Height(int value) {
        this.value = value;
    }

    public static Height valueOf(int value) {
        if(value < MIN_HEIGHT) {
            throw new IllegalArgumentException(GUIDE_ERR_HEIGHT_LESS_THAN);
        }
        return new Height(value);
    }

    public int size() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Height)) return false;
        final Height height = (Height) o;
        return value == height.value;
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
