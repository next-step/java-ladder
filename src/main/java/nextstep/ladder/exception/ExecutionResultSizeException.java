package nextstep.ladder.exception;

public class ExecutionResultSizeException extends IllegalArgumentException {

    private static final String MESSAGE = "결과 값 수와 플레이어 수는 같아야 합니다.";

    public ExecutionResultSizeException() {
        super(MESSAGE);
    }

}
