package ladder.model;

import java.util.List;

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

    public LadderPole move(final List<LadderBridge> bridges) {
        if (polePosition != 0 && bridges.get(polePosition - 1) == LadderBridge.EXIST) {
            return LadderPole.create(polePosition - 1);
        }

        if (polePosition != bridges.size() && bridges.get(polePosition) == LadderBridge.EXIST) {
            return LadderPole.create(polePosition + 1);
        }

        return this;
    }

    public int getPolePosition() {
        return polePosition;
    }
}
