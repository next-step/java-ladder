package nextstep.ladder.domain.exceptions;

public class InvalidGameResultParameterException extends RuntimeException {
    public InvalidGameResultParameterException(String message) {
        super(message);
    }
}
