package ladder.exception;

public class InvalidLinesException extends RuntimeException {

    public InvalidLinesException() {
        super("잘못되게 그려진 라인이 있습니다.");
    }
}
