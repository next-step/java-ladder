package nextstep.ladder.exception;

public class LineDuplicateException extends RuntimeException {
    private static final String MESSAGE = "가로 라인이 겹칩니다.";

    public LineDuplicateException() {
        super(MESSAGE);
    }

}
