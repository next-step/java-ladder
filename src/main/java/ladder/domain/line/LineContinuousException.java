package ladder.domain.line;

public class LineContinuousException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "라인은 연속되어 생성될 수 없습니다.";

    public LineContinuousException() {
        super(DEFAULT_MESSAGE);
    }

}
