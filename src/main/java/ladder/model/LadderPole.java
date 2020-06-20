package ladder.model;

public class LadderPole {

    private final int polePosition;

    private LadderPole(final int polePosition) {
        if (polePosition < 0) {
            throw new IllegalArgumentException("사다라의 세로 라인은 0 이상이어야 합니다.");
        }
        this.polePosition = polePosition;
    }

    public static LadderPole create(final int polePosition) {
        return new LadderPole(polePosition);
    }

    public static LadderPole create(final LadderPole ladderPole) {
        return new LadderPole(ladderPole.polePosition);
    }

    public int toInt() {
        return polePosition;
    }
}
