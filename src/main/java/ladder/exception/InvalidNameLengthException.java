package ladder.exception;

public class InvalidNameLengthException extends RuntimeException {

    public static final String INVALID_NAME_LENGTH = "이름을 입력하시지 않았거나 길이가 5자 이상입니다.";

    public InvalidNameLengthException() {
        this(INVALID_NAME_LENGTH);
    }

    public InvalidNameLengthException(String message) {
        super(message);
    }
}
