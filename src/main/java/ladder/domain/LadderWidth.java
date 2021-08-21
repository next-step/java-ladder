package ladder.domain;

import java.util.Objects;

public class LadderWidth {
    private static final int MIN_COUNT = 2;

    private final int ladderWidth;

    public LadderWidth(final int ladderWidth) {
        validateGreaterThanOne(ladderWidth);
        this.ladderWidth = ladderWidth;
    }

    private void validateGreaterThanOne(final int ladderWidth) {
        if (ladderWidth < MIN_COUNT) {
            throw new IllegalArgumentException("사다리 넓이는 최소 2 이상입니다.");
        }
    }

    public int getValue() {
        return ladderWidth;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LadderWidth that = (LadderWidth) o;
        return ladderWidth == that.ladderWidth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderWidth);
    }
}
