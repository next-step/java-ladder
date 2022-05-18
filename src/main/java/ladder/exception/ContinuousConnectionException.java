package ladder.exception;

public class ContinuousConnectionException extends IllegalArgumentException {

    private static final String MESSAGE = "사다리 라인은 연속으로 연결될 수 없습니다.";

    public ContinuousConnectionException() {
        super(MESSAGE);
    }
}
