package nextstep.ladder.domain.exception;

public class RequiredArgumentException extends ServiceException {

    public static final String MESSAGE = "필수 값이 없습니다.";

    public RequiredArgumentException() {
        super(MESSAGE);
    }
}
