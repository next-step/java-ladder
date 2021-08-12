package nextstep.ladder.domain.exception;

public class InputInvalidException extends RuntimeException {
    public InputInvalidException() {
        super();
    }

    public InputInvalidException(final String message) {
        super(message);
    }
}
