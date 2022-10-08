package ladder.step2.domain;

import java.util.Collections;
import java.util.Map;

public class LadderGameResults {
    private final Map<String, String> ladderGameResults;
    
    public LadderGameResults(final Map<String, String> ladderGameResults) {
        this.ladderGameResults = ladderGameResults;
    }
    
    public Map<String, String> getLadderGameResults() {
        return Collections.unmodifiableMap(ladderGameResults);
    }
}
