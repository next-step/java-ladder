package ladder.step2.dto;

import ladder.step2.domain.LadderResult;

public class LadderResultDTO {
    private final String ladderResult;
    
    public LadderResultDTO(LadderResult ladderResult) {
        this.ladderResult = ladderResult.getLadderResult();
    }
    
    public String getLadderResult() {
        return ladderResult;
    }
}
