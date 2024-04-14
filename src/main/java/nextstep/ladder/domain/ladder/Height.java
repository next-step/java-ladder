package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Height {
    private final int value;

    public Height(int value) {
        assertPositive(value);

        this.value = value;
    }

    private void assertPositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("사다리 높이는 양수여야 합니다.");
        }
    }

    public int value() {
        return this.value;
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
