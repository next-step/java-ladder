package laddergame.exception;

import laddergame.exception.ErrorCode;

public class LadderGameException extends RuntimeException {
    public LadderGameException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
