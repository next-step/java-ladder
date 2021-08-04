package nextstep.ladder.domain.common.exception;

public class InvalidNameException extends RuntimeException {

    private static final String MESSAGE = "이름은 최대 5글자입니다.";

    public InvalidNameException() {
        super(MESSAGE);
    }
}
