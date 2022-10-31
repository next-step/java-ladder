package ladder.exception;

public class UnknownNameException extends RuntimeException {

    public UnknownNameException() {
        super("참여자의 이름이 없습니다. 다시 확인하세요.");
    }
}
