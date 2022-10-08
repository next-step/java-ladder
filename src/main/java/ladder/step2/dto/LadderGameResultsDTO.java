package ladder.step2.dto;

import ladder.step2.domain.LadderGameResults;

import java.util.Map;

public class LadderGameResultsDTO {
    private final Map<String, String> ladderGameResults;
    
    public LadderGameResultsDTO(final LadderGameResults ladderGameResults) {
        this.ladderGameResults = ladderGameResults.getLadderGameResults();
    }
    
    public Map<String, String> getLadderGameResults() {
        return ladderGameResults;
    }
}
