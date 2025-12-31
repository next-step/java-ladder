package nextstep.ladder.domain.ladder;

import java.util.List;

public class LadderResults {

    private List<LadderResult> results;

    public LadderResults(LadderResult... results) {
        this(List.of(results));
    }

    public LadderResults(List<LadderResult> results) {
        this.results = results;
    }

    public List<LadderResult> getResults() {
        return results;
    }

    public int size() {
        return this.results.size();
    }

    @Override
    public String toString() {
        return "LadderResults{" +
                "results=" + results +
                '}';
    }
}
