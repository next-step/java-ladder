package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Height {
    private final int value;

    public Height(int value) {
        assertPositive(value);

        this.value = value;
    }

    private void assertPositive(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("사다리 높이는 음수가 될 수 없습니다.");
        }
    }

    public int value() {
        return this.value;
    }

    public boolean isZero() {
        return value == 0;
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
