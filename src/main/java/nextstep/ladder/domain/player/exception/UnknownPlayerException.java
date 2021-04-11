package nextstep.ladder.domain.player.exception;

public class UnknownPlayerException extends RuntimeException {

    private static final String MESSAGE = "그런 이름을 가진 참가자가 없습니다.";

    public UnknownPlayerException() {
        super(MESSAGE);
    }
}
