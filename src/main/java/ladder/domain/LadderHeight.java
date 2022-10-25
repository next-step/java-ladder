package ladder.domain;

import ladder.exception.LadderHeightBoundException;

import java.util.Objects;

public class LadderHeight {

    private final int height;
    private static final int LADDER_HEIGHT_MIN = 1;

    public LadderHeight(int height) {
        if (height < LADDER_HEIGHT_MIN) {
            throw new LadderHeightBoundException(LADDER_HEIGHT_MIN);
        }
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderHeight that = (LadderHeight) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
