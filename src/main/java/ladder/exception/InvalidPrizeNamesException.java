package ladder.exception;

public class InvalidPrizeNamesException extends RuntimeException {

    public static final String INVALID_PRIZES_MESSAGE = "실행 결과를 쉼표로 구분하여 입력해 주세요.";

    public InvalidPrizeNamesException() {
        this(INVALID_PRIZES_MESSAGE);
    }

    public InvalidPrizeNamesException(String message) {
        super(message);
    }
}
