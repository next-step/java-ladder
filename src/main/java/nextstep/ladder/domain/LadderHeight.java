package nextstep.ladder.domain;

import java.util.Objects;

import nextstep.ladder.engine.Height;

public class LadderHeight implements Height {
    private final int height;

    private LadderHeight(final int height) {
        this.height = height;
    }

    public static LadderHeight of(final int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("invalid height: must larger than 0, but " + height);
        }

        return new LadderHeight(height);
    }

    @Override
    public int toInt() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderHeight ladderHeight = (LadderHeight) o;
        return this.height == ladderHeight.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

    @Override
    public String toString() {
        return "Height{" +
                "height=" + height +
                '}';
    }
}
