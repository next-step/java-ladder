package ladder.exception;

public class HeightOutOfBoundException extends IllegalArgumentException {
    private static final String MESSAGE = "높이는 1 이상이여야 합니다. : %d";

    public HeightOutOfBoundException(int causativeValue) {
        super(String.format(MESSAGE, causativeValue));
    }
}
