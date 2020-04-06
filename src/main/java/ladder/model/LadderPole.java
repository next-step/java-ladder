package ladder.model;

public class LadderPole {
    private final int polePosition;

    private LadderPole(int polePosition) {
        if (polePosition < 0) {
            throw new RuntimeException("Ladder pole must be greater than zero.");
        }
        this.polePosition = polePosition;
    }

    public static LadderPole of(int polePosition) {
        return new LadderPole(polePosition);
    }

    public int getPolePosition() {
        return polePosition;
    }
}
