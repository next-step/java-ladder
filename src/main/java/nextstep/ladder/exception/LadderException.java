package nextstep.ladder.exception;

public class LadderException extends RuntimeException{

    public LadderException() {
    }

    public LadderException(LadderExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
    }

    public LadderException(LadderExceptionCode exceptionCode, String value) {
        super(String.format(exceptionCode.getMessage() + " 입력값 = %s", value));
    }
}
