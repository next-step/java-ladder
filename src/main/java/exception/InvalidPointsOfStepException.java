package exception;

public class InvalidPointsOfStepException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "사다리의 라인이 겹쳐있으면 안됩니다.";

    public InvalidPointsOfStepException() {
        super(ERROR_MESSAGE);
    }
}
