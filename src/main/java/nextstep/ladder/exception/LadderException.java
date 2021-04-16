package nextstep.ladder.exception;

public class LadderException extends IllegalArgumentException {
    public LadderException(LadderExceptionMessage message) {
        super(message.errorMessage());
    }
}
