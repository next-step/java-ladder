package ladder.exception;

public class InvalidPointException extends IllegalArgumentException {
    private static final String MESSAGE = "인접 한 열의 Point 연속으로 true 입니다. false 를 입력하세요.";

    public InvalidPointException() {
        super(MESSAGE);
    }
}