package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Height {

    private final int height;

    private Height(int height) {
        this.height = height;
    }

    public static Height of(int height) {
        return new Height(height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height1 = (Height) o;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
