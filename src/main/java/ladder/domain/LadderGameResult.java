package ladder.domain;

import java.util.Map;

public class LadderGameResult {
    private final Map<String, Integer> results;
    private final Ladder ladder;

    public LadderGameResult(Map<String, Integer> results, Ladder ladder) {
        this.results = results;
        this.ladder = ladder;
    }
}
