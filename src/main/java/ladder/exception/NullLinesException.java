package ladder.exception;

public class NullLinesException extends RuntimeException {

    public NullLinesException() {
        super("라인들은 null 이면 안됩니다.");
    }
}
