package nextstep.ladder.domain.line.exception;

public class UnknownPointException extends RuntimeException {

    private static final String MESSAGE = "";

    public UnknownPointException() {
        super(MESSAGE);
    }
}
