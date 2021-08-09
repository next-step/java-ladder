package nextstep.ladder.domain.exception;

public class InvalidCreateLineException extends RuntimeException {

    private static final String MESSAGE = "유효하지 않은 라인 초기 값 입니다.";

    public InvalidCreateLineException() {
        super(MESSAGE);
    }
}
