package ladder.step2.dto;

import ladder.step2.domain.LadderGameResults;

import java.util.HashMap;

public class LadderGameResultsDTO {
    private final HashMap<String, String> ladderGameResults;
    
    public LadderGameResultsDTO(final LadderGameResults ladderGameResults) {
        this.ladderGameResults = ladderGameResults.getLadderGameResults();
    }
    
    public HashMap<String, String> getLadderGameResults() {
        return ladderGameResults;
    }
}
