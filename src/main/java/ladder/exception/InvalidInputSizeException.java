package ladder.exception;

public class InvalidInputSizeException extends RuntimeException {

    public static final String INVALID_INPUT_SIZE_MESSAGE_FORMAT = "참여자와 실행 결과 수가 다릅니다. 사용자: %d, 결과: %d";

    public InvalidInputSizeException(int participantsSize, int executionResultsSize) {
        super(String.format(INVALID_INPUT_SIZE_MESSAGE_FORMAT, participantsSize, executionResultsSize));
    }
}
