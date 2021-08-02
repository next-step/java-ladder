package nextstep.ladder.exception;

public class NotFoundLadderTypeException extends RuntimeException {
    public NotFoundLadderTypeException() {
        super("일치하는 사다리 타입이 없습니다.");
    }
}
