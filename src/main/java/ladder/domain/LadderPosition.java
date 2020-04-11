package ladder.domain;

import java.util.Objects;

public class LadderPosition {
    private final int position;

    public static LadderPosition of(int position) {
        return new LadderPosition(position);
    }

    private LadderPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException();
        }
        this.position = position;
    }

    LadderPosition move(LadderLine ladderLine) {
        if (ladderLine.isLinkConnect(position)) {
            return new LadderPosition(position - 1);
        }

        if (ladderLine.isLinkConnect(position + 1)) {
            return new LadderPosition(position + 1);
        }
        return this;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderPosition)) return false;
        LadderPosition that = (LadderPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
