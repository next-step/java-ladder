package nextstep.ladder.domain.exceptions;

public class PlayerNameEmptyException extends RuntimeException {
    public PlayerNameEmptyException(String message) {
        super(message);
    }
}
