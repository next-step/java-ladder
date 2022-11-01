package ladder.exception;

public class InvalidBridgeLinesSizeException extends RuntimeException {

    public InvalidBridgeLinesSizeException() {
        super("사다리 다리 라인은 최소 2개 이상이여야 합니다.");
    }
}
