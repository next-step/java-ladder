package ladder.step2.domain;

import java.util.HashMap;

public class LadderGameResults {
    private final HashMap<String, String> ladderGameResults;
    
    public LadderGameResults(final HashMap<String, String> ladderGameResults) {
        this.ladderGameResults = ladderGameResults;
    }
    
    public HashMap<String, String> getLadderGameResults() {
        return ladderGameResults;
    }
}
