package nextstep.ladder.domain;

import java.util.Objects;

public class LadderHeight {
    private final int height;

    public LadderHeight(String height) {
        this(Integer.valueOf(height));
    }

    public LadderHeight(int height) {
        this.height = height;
    }

    public int value() {
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
}
