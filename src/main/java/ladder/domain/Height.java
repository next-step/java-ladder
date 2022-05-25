package ladder.domain;

import java.util.Objects;
import java.util.Optional;

public class Height {
    public static final int MAX_HEIGHT = 20;
    private final int height;

    public Height(int height) {
        this.height = Optional.of(height)
                .filter(h -> h <= MAX_HEIGHT)
                .orElseThrow(() -> new IllegalArgumentException("height should be less than " + MAX_HEIGHT + " but, : " + height));
    }

    public int height() {
        return this.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height1 = (Height) o;
        return height == height1.height;
    }
}
