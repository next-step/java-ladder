package laddergame;

public class LadderGameException extends RuntimeException {
    public LadderGameException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
