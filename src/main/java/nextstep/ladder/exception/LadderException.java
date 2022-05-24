package nextstep.ladder.exception;

public class LadderException extends RuntimeException{

    public LadderException(String message) {
        super(message);
    }

    public LadderException(LadderExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
    }

    public LadderException(LadderExceptionCode exceptionCode, String value) {
        super(String.format("%s 입력값 = %s", exceptionCode.getMessage(), value));
    }
}
