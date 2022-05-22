package nextstep.ladder.exception;

public class NotFoundPersonException extends RuntimeException {

    private static final String NOT_FOUND_SEQUENCE_MESSAGE = "%s 의 참여자를 찾을 수 없습니다.";

    public NotFoundPersonException() {
        super(NOT_FOUND_SEQUENCE_MESSAGE);
    }
}
