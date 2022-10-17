package ladder.step2.dto;

import ladder.step2.exception.LadderResultLengthExceededException;

public class LadderResultDTO {
    private static final int MAX_LENGTH_OF_LADDER_RESULT_NAME = 7;
    
    private final String ladderResult;
    
    public LadderResultDTO(String ladderResult) {
        if (ladderResult.length() > MAX_LENGTH_OF_LADDER_RESULT_NAME) {
            throw new LadderResultLengthExceededException();
        }
        
        this.ladderResult = ladderResult;
    }
    
    public String getLadderResult() {
        return ladderResult;
    }
}
