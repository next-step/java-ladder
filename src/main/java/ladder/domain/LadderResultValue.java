package ladder.domain;

import java.util.List;

public class LadderResultValue {

    private final List<LadderResult> results;

    public LadderResultValue(List<LadderResult> results) {
        this.results = results;
    }

    public List<LadderResult> getResults() {
        return this.results;
    }

    public LadderResult getPosition(int index) {
        return this.results.get(index);
    }

}
