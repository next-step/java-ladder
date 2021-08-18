package ladder.domain.line;

public class LinesSizeException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "사다리의 높이는 1 이상 이어야 합니다.";

    public LinesSizeException() {
        super(DEFAULT_MESSAGE);
    }

}
