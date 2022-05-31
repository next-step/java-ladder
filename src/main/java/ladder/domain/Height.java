package ladder.domain;

import java.util.Objects;
import java.util.Optional;

public class Height {
    private final int MAX_HEIGHT = 20;
    private final int value;

    public Height(int height) {
        this.value = Optional.of(height)
                .filter(height -> height <= MAX_HEIGHT)
                .orElseThrow(() -> new IllegalArgumentException("height should be less than " + MAX_HEIGHT + " but, : " + height));
    }

    public int value() {
        return this.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height1 = (Height) o;
        return value == height1.value;
    }
}