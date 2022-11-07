package ladder.domain.exception;

public class InvalidLineException extends RuntimeException {

    public InvalidLineException() {
        super("올바르지 않은 바가 존재하는 라인입니다.");
    }
}
