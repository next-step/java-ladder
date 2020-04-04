package ladder.domain;

import java.util.Objects;

public class Height {
    private int value;

    public Height(final String value) {
        this(Integer.valueOf(value));
    }

    public Height(final int value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Height height = (Height) o;
        return value == height.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
