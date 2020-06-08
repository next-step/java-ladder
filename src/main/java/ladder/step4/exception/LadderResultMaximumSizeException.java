package ladder.step4.exception;

public class LadderResultMaximumSizeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "사다리 결과의 값은 5글자 이하여야합니다.";

    public LadderResultMaximumSizeException() {
        super(ERROR_MESSAGE);
    }

}
