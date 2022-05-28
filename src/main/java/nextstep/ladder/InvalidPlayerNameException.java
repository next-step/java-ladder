package nextstep.ladder;

public class InvalidPlayerNameException extends RuntimeException {
    public InvalidPlayerNameException(final String message) {
        super(message);
    }
}
