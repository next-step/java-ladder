package nextstep.ladder.exception;

public class ResultException extends RuntimeException {
    private static final String MESSAGE = "결과를 잘못 입력 했어요.";

    public ResultException() {
        super(MESSAGE);
    }
}
