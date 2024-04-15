package ladder.domain;

import java.util.List;

public class Ladder {

    private Lines lines;
    private Ladder(int height, int countOfPlayer) {
        Lines lines = new Lines(height, countOfPlayer);
        this.lines = lines;
    }

    public static Ladder of(int height, int countOfPlayer) {
        Ladder ladder = new Ladder(height, countOfPlayer);

        if (!ladder.lines.hasAtLeastOneBridge(countOfPlayer)) {
            return Ladder.of(height, countOfPlayer);
        }

        return ladder;
    }

    public Lines getLines() {
        return this.lines;
    }
}
