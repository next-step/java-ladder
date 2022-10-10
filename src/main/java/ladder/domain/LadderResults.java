package ladder.domain;

import java.util.List;

public class LadderResults {
    private final List<LadderResult> ladderResults;

    public LadderResults(List<LadderResult> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public List<LadderResult> ladderResults() {
        return ladderResults;
    }
}
