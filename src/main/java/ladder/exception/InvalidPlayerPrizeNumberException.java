package ladder.exception;

public class InvalidPlayerPrizeNumberException extends RuntimeException {

    public static final String INVALID_NUMBERS_MESSAGE = "참여자 숫자와 결과물 숫자가 같아야 합니다.";

    public InvalidPlayerPrizeNumberException() {
        this(INVALID_NUMBERS_MESSAGE);
    }

    public InvalidPlayerPrizeNumberException(String message) {
        super(message);
    }
}
