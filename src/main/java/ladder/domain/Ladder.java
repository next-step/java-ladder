package ladder.domain;

import java.util.List;

public class Ladder {
    private final Lines lines;
    private final LadderResult ladderResult;

    private Ladder(Lines lines, LadderResult ladderResult) {
        this.ladderResult = ladderResult;
        this.lines = lines;
    }

    public static Ladder getInstance(Lines lines, LadderResult ladderResult) {
        return new Ladder(lines, ladderResult);
    }

    public boolean isHeightSame(int height) {
        return this.lines.isHeightSame(height);
    }

    public LadderResult getLadderResult() {
        return LadderResult.getNewInstance(ladderResult);
    }

    public List<Line> getLines() {
        return lines.getLines();
    }
}
