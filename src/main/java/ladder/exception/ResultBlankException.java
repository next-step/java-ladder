package ladder.exception;

public class ResultBlankException extends IllegalArgumentException {

    private static final String MESSAGE = "결과는 빈값일 수 없습니다";

    public ResultBlankException() {
        super(MESSAGE);
    }

}
