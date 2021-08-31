package nextstep.ladders.exception;

public class InvalidLineSizeException extends RuntimeException {

    public InvalidLineSizeException() {
        super("라인의 길이를 초과하였습니다.");
    }
}
