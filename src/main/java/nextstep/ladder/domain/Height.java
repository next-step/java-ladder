package nextstep.ladder.domain;

import java.util.Objects;

public class Height {
    private final int value;

    public Height(int value) {
        this.value = value;
    }

    public static Height valueOf(int value) {
        if(value < 0) {
            throw new IllegalArgumentException("사다리 높이가 0보다 작을 수는 없습니다.");
        }
        return new Height(value);
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
