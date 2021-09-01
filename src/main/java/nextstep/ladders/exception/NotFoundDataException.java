package nextstep.ladders.exception;

public class NotFoundDataException extends RuntimeException {

    public NotFoundDataException() {
        super("데이터를 찾을 수 없습니다.");
    }

    public NotFoundDataException(String message) {
        super(message);
    }
}
