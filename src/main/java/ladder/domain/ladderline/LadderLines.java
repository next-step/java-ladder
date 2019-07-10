package ladder.domain.ladderline;

import java.util.Collections;
import java.util.List;

public class LadderLines {
    private List<LadderLine> ladderLines;

    private LadderLines(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    static LadderLines of(List<LadderLine> ladderLines) {
        return new LadderLines(ladderLines);
    }

    public List<LadderLine> get() {
        return Collections.unmodifiableList(ladderLines);
    }

    Index move(Index startIndex) {
        for (LadderLine ladderLine : ladderLines) {
            startIndex = ladderLine.move(startIndex);
        }
        return startIndex;
    }

    @Override
    public String toString() {
        return "LadderLines{" +
                "ladderLines=" + ladderLines +
                '}';
    }
}
