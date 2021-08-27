package ladder.exception;

public class LadderGameDifferentSizeException extends IllegalArgumentException {

    private static final String MESSAGE = "유저 수와 결과 수가 다릅니다.";

    public LadderGameDifferentSizeException() {
        super(MESSAGE);
    }
}
