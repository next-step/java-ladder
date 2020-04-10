package ladder.model;

import java.util.Objects;

public class LadderPole {

    private final int polePosition;

    private LadderPole(final int polePosition) {
        if (polePosition < 0) {
            throw new IllegalArgumentException("Ladder pole must be greater than zero.");
        }
        this.polePosition = polePosition;
    }

    public static LadderPole of(final int polePosition) {
        return new LadderPole(polePosition);
    }

    public static LadderPole of(final LadderPole ladderPole) {
        return new LadderPole(ladderPole.polePosition);
    }

    public int toInt() {
        return polePosition;
    }

    public LadderPole plus() {
        return new LadderPole(polePosition + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderPole)) return false;
        LadderPole that = (LadderPole) o;
        return polePosition == that.polePosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(polePosition);
    }
}
