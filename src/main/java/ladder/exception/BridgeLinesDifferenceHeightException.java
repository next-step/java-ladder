package ladder.exception;

public class BridgeLinesDifferenceHeightException extends RuntimeException {

    public BridgeLinesDifferenceHeightException() {
        super("사다리 다리 라인들의 높이는 동일해야 합니다.");
    }
}
