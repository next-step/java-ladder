package ladder.exception;

public class UnableReachLineCount extends RuntimeException {
    public UnableReachLineCount() {
        super("사용자가 지정한 Line 수에 도달할수 없습니다. 무한루프가 감지됨");
    }
}
