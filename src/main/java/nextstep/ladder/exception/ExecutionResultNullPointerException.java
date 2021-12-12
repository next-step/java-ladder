package nextstep.ladder.exception;

public class ExecutionResultNullPointerException extends NullPointerException {

    private static final String MESSAGE = "결과를 입력해주세요.";

    public ExecutionResultNullPointerException() {
        super(MESSAGE);
    }

}
