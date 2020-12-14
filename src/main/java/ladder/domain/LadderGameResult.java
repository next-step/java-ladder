package ladder.domain;

import java.util.Map;

public class LadderGameResult {
    private final Map<String, String> results;
    private final Ladder ladder;

    public LadderGameResult(Map<String, String> results, Ladder ladder) {
        this.results = results;
        this.ladder = ladder;
    }

    public Map<String, String> getResults() {
        return results;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
