package ladder.exception;

public class InvalidPlayerNameException extends RuntimeException {

    public static final String INVALID_LENGTH_MESSAGE = "이름이 비어있거나 5자 이상입니다.";

    public InvalidPlayerNameException() {
        this(INVALID_LENGTH_MESSAGE);
    }

    public InvalidPlayerNameException(String message) {
        super(message);
    }
}
