package ladder.model;

import java.util.Objects;

public class PoleCount {
    private final int count;

    private PoleCount(final int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Ladder Pole count must be greater than zero.");
        }
        this.count = count;
    }

    public static PoleCount of(final int count) {
        return new PoleCount(count);
    }

    public int toInt() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PoleCount)) return false;
        PoleCount that = (PoleCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
