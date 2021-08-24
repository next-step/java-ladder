package ladder.exception;

public class EmptyResultValueException extends IllegalArgumentException {

    private static final String MESSAGE = "당첨 결과를 입력해 주세요.";

    public EmptyResultValueException() {
        super(MESSAGE);
    }
}