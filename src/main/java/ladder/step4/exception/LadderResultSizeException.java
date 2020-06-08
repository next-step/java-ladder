package ladder.step4.exception;

public class LadderResultSizeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "결과의 갯수는 참여자의 수와 일치해야 합니다.";

    public LadderResultSizeException() {
        super(ERROR_MESSAGE);
    }

}
