package ladder.model;

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
}
