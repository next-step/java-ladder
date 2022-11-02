package ladder.exception;

public class InvalidLadderHeightException extends RuntimeException {

    public InvalidLadderHeightException() {
        super("유효하지 않은 사다리 높이입니다.");
    }
}
