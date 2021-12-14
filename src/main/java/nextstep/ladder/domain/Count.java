package nextstep.ladder.domain;

import java.util.Objects;

public abstract class Count {
    private final int count;

    protected Count(final int count) {
        this.count = count;
    }

    public int toInt() {
        return count;
    }

    public boolean equalValue(Count other) {
        return other != null && other.count == count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count other = (Count) o;
        return count == other.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
