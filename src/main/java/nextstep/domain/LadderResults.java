package nextstep.domain;

import nextstep.domain.LadderResult;

import java.util.List;

public class LadderResults {

    private final List<LadderResult> ladderResults;

    public LadderResults(List<LadderResult> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public List<LadderResult> getLadderResults() {
        return ladderResults;

    }
}
