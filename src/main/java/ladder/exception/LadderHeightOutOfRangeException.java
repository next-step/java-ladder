package ladder.exception;

public class LadderHeightOutOfRangeException extends IllegalArgumentException {
    private static final String MESSAGE = "사다리의 높이는 최소 1 이상 입니다.";

    public LadderHeightOutOfRangeException() {
        super(MESSAGE);
    }
}
