package ladder.exception;

public class InvalidNameException extends IllegalArgumentException {
    private static final String MESSAGE = "이름에 공백이나 빈 값이 올 수 없습니다. : %s";

    public InvalidNameException(String causativeValue) {
        super(String.format(MESSAGE, causativeValue));
    }
}
