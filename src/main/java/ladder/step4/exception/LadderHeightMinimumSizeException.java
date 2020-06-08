package ladder.step4.exception;

public class LadderHeightMinimumSizeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "사다리의 최소 높이는 1 이상입니다.";

    public LadderHeightMinimumSizeException() {
        super(ERROR_MESSAGE);
    }

}
