package nextstep.ladder.domain.exception;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException() {
        super();
    }

    public InvalidInputException(final String message) {
        super(message);
    }
}
