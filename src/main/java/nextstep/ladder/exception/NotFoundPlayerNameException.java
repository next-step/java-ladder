package nextstep.ladder.exception;

public class NotFoundPlayerNameException extends RuntimeException {
    public NotFoundPlayerNameException(String name) {
        super("입력한 플레이어의 이름을 찾을 수 없습니다. ===" + name);
    }
}
