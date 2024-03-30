package nextstep.ladder.domain.player;

import java.util.Objects;

public class Count {
    private final int value;

    public Count(int value) {
        assertPositive(value);
        this.value = value;
    }

    private void assertPositive(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("개수는 음수가 될 수 없습니다.");
        }
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count = (Count) o;
        return value == count.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
