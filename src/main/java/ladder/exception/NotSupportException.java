package ladder.exception;

public class NotSupportException extends RuntimeException {

    private static final String MESSAGE = "생성이 불가능한 클래스입니다.";

    public NotSupportException() {
        super(MESSAGE);
    }
}
