package nextstep.ladder.domain;

import java.util.Objects;

public class Height {
    private final int height;

    public Height(String height) {
        this(Integer.valueOf(height));
    }

    public Height(int height) {
        this.height = height;
    }

    public int value() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height = (Height) o;
        return this.height == height.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
