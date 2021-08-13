package nextstep.ladder.domain.exception;

public class InvalidCreateHorizontalLineException extends RuntimeException {

    private static final String MESSAGE = "유효하지 않은 가로줄 초기 값 입니다.";

    public InvalidCreateHorizontalLineException() {
        super(MESSAGE);
    }
}
