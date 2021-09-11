package ladder.exception;

public class InvalidPositionException extends RuntimeException {
    private static final String MESSAGE = "유효한 Position 범위(%d 이상 %d 이하)를 넘었습니다. (값 : %d)";

    public InvalidPositionException(int value, int min, int max) {
        super(String.format(MESSAGE, min, max, value));
    }
}
