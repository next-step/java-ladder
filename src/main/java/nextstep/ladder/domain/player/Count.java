package nextstep.ladder.domain.player;

import java.util.Objects;
import java.util.stream.IntStream;

public class Count implements Comparable<Count> {
    private final int value;

    public Count() {
        this(0);
    }

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

    public Count subtract(int value) {
        if (this.value < value) {
            return new Count();
        }
        return new Count(this.value - value);
    }

    public boolean equals(int value) {
        return this.value == value;
    }

    public Count max(Count other) {
        if (this.compareTo(other) <= 0) {
            return other;
        }
        return this;
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

    @Override
    public int compareTo(Count other) {
        return Integer.compare(this.value, other.value);
    }
}
