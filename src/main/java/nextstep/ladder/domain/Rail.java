package nextstep.ladder.domain;

import java.util.Objects;

public class Rail {
    private final Height height;

    private Rail(final Height height) {
        this.height = height;
    }

    public static Rail of(final int height) {
        return new Rail(Height.of(height));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rail rail = (Rail) o;
        return Objects.equals(height, rail.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
