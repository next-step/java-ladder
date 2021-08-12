package nextstep.ladder.domain.exception;

public class LadderGameInitializeException extends RuntimeException {
    public LadderGameInitializeException() {
        super();
    }

    public LadderGameInitializeException(final String message) {
        super(message);
    }
}
