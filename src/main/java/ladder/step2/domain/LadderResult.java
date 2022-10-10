package ladder.step2.domain;

public class LadderResult {
    private static final String LADDER_RESULT_LENGTH_EXCEED_EXCEPTION_MESSAGE = "하나의 실행 결과의 문자 길이는 7자를 초과할 수 없습니다. 다시 입력해주세요.";
    private static final int LADDER_RESULT_MAX_LENGTH = 7;
    
    private final String ladderResult;
    
    public LadderResult(String ladderResult) {
        if (ladderResult.length() > LADDER_RESULT_MAX_LENGTH) {
            throw new IllegalArgumentException(LADDER_RESULT_LENGTH_EXCEED_EXCEPTION_MESSAGE);
        }
        
        this.ladderResult = ladderResult;
    }
    
    public String getLadderResult() {
        return ladderResult;
    }
}
