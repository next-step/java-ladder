package ladder.domain;

import java.util.Objects;

public class LadderHeight {
    private static final int MIN_COUNT = 1;

    private final int ladderHeight;

    public LadderHeight(final int ladderHeight) {
        validateGreaterThanZero(ladderHeight);
        this.ladderHeight = ladderHeight;
    }

    private void validateGreaterThanZero(final int ladderHeight) {
        if (ladderHeight < MIN_COUNT) {
            throw new IllegalArgumentException("사다리 높이는 최소 1 이상입니다.");
        }
    }

    public int getValue() {
        return ladderHeight;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LadderHeight that = (LadderHeight) o;
        return ladderHeight == that.ladderHeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderHeight);
    }
}
