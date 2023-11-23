package ladder.domain;

import java.util.Objects;

public class Height {
    private final int count;

    public Height(int count) {
        this.count = count;
    }

    public int find() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height count1 = (Height) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
