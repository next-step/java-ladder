package ladder.domain;

import java.util.List;

public class LadderGameSimulator {
    private final Ladder ladder;

    public LadderGameSimulator(Ladder ladder) {
        this.ladder = ladder;
    }

    public int simulate(int index) {
        List<Line> lines = ladder.getLines();
        int currentIndex = index;

        for (Line line : lines) {
            currentIndex = currentIndex + line.getPoints()
                .get(currentIndex)
                .getMove();
        }

        return currentIndex;
    }
}
