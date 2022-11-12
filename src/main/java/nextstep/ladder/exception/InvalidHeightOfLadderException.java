package nextstep.ladder.exception;

public class InvalidHeightOfLadderException extends RuntimeException {
    public InvalidHeightOfLadderException(ErrorMessage message) {
        super(message.getMessage());
    }
}
