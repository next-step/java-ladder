package nextstep.ladder.exception;

public class LadderException extends RuntimeException{

    public LadderException() {
    }

    public LadderException(LadderExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
    }
}
