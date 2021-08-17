package ladder.exception;

public class InvalidPlayerNamesException extends RuntimeException {

    public static final String INVALID_NAMES = "이름들을 쉼표로 구분하여 입력해야 합니다.";

    public InvalidPlayerNamesException() {
        this(INVALID_NAMES);
    }

    public InvalidPlayerNamesException(String message) {
        super(message);
    }
}
