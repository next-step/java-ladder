package ladder.domain;

import java.util.List;

public class Ladder {

    private final LadderLine ladderLine;

    public Ladder(int playerCount, int height) {
        this.ladderLine = new LadderLine(playerCount, height);
    }

    public List<String> getLadderLinesString() {
        return ladderLine.toStringList();
    }

    public LadderLine getLadderLine() {
        return ladderLine;
    }
}
