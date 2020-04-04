package ladder.exception;

public class InvalidHeightException extends IllegalArgumentException {
    private static final String MESSAGE = "이름에 공백이나 빈 값이 올 수 없습니다. : %s";

    public InvalidHeightException(String causativeValue) {
        super(String.format(MESSAGE, causativeValue));
    }
}
