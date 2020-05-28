package nextstep.ladder.domain.exceptions;

public class PlayerNamesMaxLengthException extends RuntimeException {
    public PlayerNamesMaxLengthException(String message) {
        super(message);
    }
}
