package ladder.domain.exception;

public class LessThanZeroNumberException extends RuntimeException {

    private static final LessThanZeroNumberException LESS_THAN_ZERO_NUMBER_EXCEPTION =
            new LessThanZeroNumberException("0보다 작은 숫자는 입력될 수 없습니다.");

    private LessThanZeroNumberException(String message) {
        super(message);
    }

    public static LessThanZeroNumberException getInstance() {
        return LESS_THAN_ZERO_NUMBER_EXCEPTION;
    }
}
