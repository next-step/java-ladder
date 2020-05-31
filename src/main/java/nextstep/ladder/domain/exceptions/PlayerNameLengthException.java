package nextstep.ladder.domain.exceptions;

public class PlayerNameLengthException extends RuntimeException {
    public PlayerNameLengthException(String message) {
        super(message);
    }
}
