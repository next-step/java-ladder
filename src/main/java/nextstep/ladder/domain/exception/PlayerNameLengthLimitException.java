package nextstep.ladder.domain.exception;

public class PlayerNameLengthLimitException extends RuntimeException {
    public PlayerNameLengthLimitException() {
        super();
    }

    public PlayerNameLengthLimitException(final String message) {
        super(message);
    }
}
