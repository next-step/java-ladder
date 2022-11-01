package ladder.exception;

public class ContinuousBridgeLinesException extends RuntimeException {

    public ContinuousBridgeLinesException() {
        super("사다리 다리 연결이 연속될 수 없습니다.");
    }
}
