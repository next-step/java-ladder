package ladder.exception;

public class InvalidNamesPrizesException extends RuntimeException {

    public static final String INVALID_NAMES_PRIZES_NUMBER = "참여할 사람 숫자와 실행 결과 숫자가 일치해야 합니다.";

    public InvalidNamesPrizesException() {
        this(INVALID_NAMES_PRIZES_NUMBER);
    }

    public InvalidNamesPrizesException(String message) {
        super(message);
    }
}
