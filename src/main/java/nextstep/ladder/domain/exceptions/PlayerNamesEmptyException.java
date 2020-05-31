package nextstep.ladder.domain.exceptions;

public class PlayerNamesEmptyException extends RuntimeException {
    public PlayerNamesEmptyException(String message) {
        super(message);
    }
}
