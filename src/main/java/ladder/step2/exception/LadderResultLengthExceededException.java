package ladder.step2.exception;

public class LadderResultLengthExceededException extends IllegalArgumentException {
    private static final String LADDER_RESULT_LENGTH_EXCEEDED_EXCEPTION_MESSAGE = "사다리 결과 이름은 7자를 초과할 수 없습니다.";
    
    public LadderResultLengthExceededException() {
        super(LADDER_RESULT_LENGTH_EXCEEDED_EXCEPTION_MESSAGE);
    }
}
