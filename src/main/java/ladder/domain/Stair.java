package ladder.domain;

import java.util.Objects;

public class Stair {
    private final boolean stair;

    public Stair() {
        this(false);
    }

    public Stair(final boolean stair) {
        this.stair = stair;
    }

    public Stair first() {
        return new Stair(false);
    }

    public boolean isExist() {
        return stair;
    }

    public boolean getStair() {
        return stair;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Stair stair1 = (Stair) o;
        return stair == stair1.stair;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stair);
    }
}
