package ladder.exception;

public class LineDuplicateException extends RuntimeException {

    private static final String MESSAGE = "가로 라인은 겹칠 수 없습니다";

    public LineDuplicateException() {
        super(MESSAGE);
    }

}
