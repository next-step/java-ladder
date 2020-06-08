package ladder.step4.exception;

public class LadderHeightNonNumberException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "사다리의 높이는 숫자여야 합니다.";

    public LadderHeightNonNumberException() {
        super(ERROR_MESSAGE);
    }

}
