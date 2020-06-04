package nextstep.ladder.domain.exceptions;

public class PlayerNotExistException extends RuntimeException {
    public PlayerNotExistException(String message) {
        super(message);
    }
}
