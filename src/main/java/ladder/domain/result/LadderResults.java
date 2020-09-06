package ladder.domain.result;

import java.util.Collections;
import java.util.List;

public class LadderResults {
    private List<LadderResult> ladderResults;

    public LadderResults(List<LadderResult> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public List<LadderResult> getLadderResults() {
        return Collections.unmodifiableList(ladderResults);
    }
}
