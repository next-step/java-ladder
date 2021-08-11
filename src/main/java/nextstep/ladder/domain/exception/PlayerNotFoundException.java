package nextstep.ladder.domain.exception;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException() {
        super();
    }

    public PlayerNotFoundException(final String message) {
        super(message);
    }
}
