package nextstep.ladder.exception;

public class NotFoundPlayerException extends RuntimeException {
    private static String MESSAGE = "플레이어를 찾을수 없습니다.";

    public NotFoundPlayerException() {
        super(MESSAGE);
    }
}
