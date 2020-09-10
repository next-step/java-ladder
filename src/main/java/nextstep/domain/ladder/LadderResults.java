package nextstep.domain.ladder;

import java.util.List;

public class LadderResults {

    private final List<LadderResult> ladderResults;

    public LadderResults(List<LadderResult> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public LadderResult getLadderResult(int index) {
        return ladderResults.get(index);
    }

    public String getResult(int index) {
        return ladderResults.get(index).getResult();
    }

    public List<LadderResult> getLadderResults() {
        return ladderResults;
    }

}
