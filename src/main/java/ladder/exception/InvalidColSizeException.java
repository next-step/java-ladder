package ladder.exception;

public class InvalidColSizeException extends IllegalArgumentException {

    private static final String MESSAGE = "열 최소 개수를 만족하지 않습니다";

    public InvalidColSizeException() {
        super(MESSAGE);
    }

}
