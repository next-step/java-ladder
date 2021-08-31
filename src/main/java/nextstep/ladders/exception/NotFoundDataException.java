package nextstep.ladders.exception;

public class NotFoundDataException extends RuntimeException {

    public NotFoundDataException() {
        super("데이터를 찾을 수 있습니다.");
    }
}
