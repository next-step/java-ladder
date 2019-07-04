package ladder.domain.model;

import java.util.Collections;
import java.util.List;

public class LadderLines {
    private List<LadderLine> ladderLines;

    private LadderLines(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static LadderLines of(List<LadderLine> ladderLines) {
        return new LadderLines(ladderLines);
    }

    public List<LadderLine> get() {
        return Collections.unmodifiableList(ladderLines);
    }

    @Override
    public String toString() {
        return "LadderLines{" +
                "ladderLines=" + ladderLines +
                '}';
    }
}
