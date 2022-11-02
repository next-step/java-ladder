package ladder.domain.exception;

public class InvalidHeightException extends RuntimeException {

    public InvalidHeightException() {
        super("사다리 높이는 1 이상입니다.");
    }
}
