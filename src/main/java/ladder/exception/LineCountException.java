package ladder.exception;

public class LineCountException extends RuntimeException {
    private static final String LINE_COUNT_EXCEPTION = "사다리 라인의 개수가 부족합니다.";

    public LineCountException() {
        super(LINE_COUNT_EXCEPTION);
    }
}
