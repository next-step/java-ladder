package nextstep.ladder.domain;

import java.util.Map;

public class LadderResult {
    private final Map<Point,
            LadderGameSnapshot> results;

    public LadderResult(final Map<Point, LadderGameSnapshot> ladderResult) {
        this.results = ladderResult;
    }

    public Map<Point, LadderGameSnapshot> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "LadderResult{" +
                "results=" + results +
                '}';
    }
}
