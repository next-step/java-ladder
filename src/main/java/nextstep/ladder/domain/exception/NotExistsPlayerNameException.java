package nextstep.ladder.domain.exception;

public class NotExistsPlayerNameException extends RuntimeException {

    private static final String MESSAGE = "존재하지 않는 참여자 이름입니다.";

    public NotExistsPlayerNameException() {
        super(MESSAGE);
    }
}
