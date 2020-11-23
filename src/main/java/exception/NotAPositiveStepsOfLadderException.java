package exception;

public class NotAPositiveStepsOfLadderException extends IllegalArgumentException {
    private final static String ERROR_MESSAGE = "사다리 길이는 1 이상이어야 합니다.";

    public NotAPositiveStepsOfLadderException() {
        super(ERROR_MESSAGE);
    }
}
