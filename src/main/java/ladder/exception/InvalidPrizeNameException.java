package ladder.exception;

public class InvalidPrizeNameException extends RuntimeException {

    public static final String INVALID_PRIZE_MESSAGE = "결과물 이름이 필요합니다.";

    public InvalidPrizeNameException() {
        this(INVALID_PRIZE_MESSAGE);
    }

    public InvalidPrizeNameException(String message) {
        super(message);
    }
}
