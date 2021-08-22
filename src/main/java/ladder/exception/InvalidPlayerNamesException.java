package ladder.exception;

public class InvalidPlayerNamesException extends RuntimeException {

    public static final String INVALID_NAMES_MESSAGE = "참여할 사람 이름을 쉼표(,)로 구분하여 입려하여 주십시오.";

    public InvalidPlayerNamesException() {
        this(INVALID_NAMES_MESSAGE);
    }

    public InvalidPlayerNamesException(String message) {
        super(message);
    }
}
