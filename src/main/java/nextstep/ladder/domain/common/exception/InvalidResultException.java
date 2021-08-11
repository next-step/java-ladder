package nextstep.ladder.domain.common.exception;

public class InvalidResultException extends NumberFormatException {

    private static final String MESSAGE = "결과로 변환할 수 없는 입력 값 입니다.";

    public InvalidResultException() {
        super(MESSAGE);
    }
}
