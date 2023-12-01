package ladder.model;

import java.util.Map;

public class LadderResult {

    private final Map<Player, Prize> results;

    public LadderResult(Map<Player, Prize> results) {
        this.results = results;
    }

    public Map<Player, Prize> getResults() {
        return this.results;
    }
}
