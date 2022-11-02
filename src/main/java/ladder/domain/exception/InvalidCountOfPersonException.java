package ladder.domain.exception;

public class InvalidCountOfPersonException extends RuntimeException {

    public InvalidCountOfPersonException() {
        super("사람수는 한 명 이상이야 합니다.");
    }
}
