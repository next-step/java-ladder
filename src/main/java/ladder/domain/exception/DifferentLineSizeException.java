package ladder.domain.exception;

public class DifferentLineSizeException extends RuntimeException {

    private static final DifferentLineSizeException DIFFERENT_LINE_SIZE_EXCEPTION =
            new DifferentLineSizeException("라인의 사이즈가 동일하지 않습니다.");

    private DifferentLineSizeException(String message) {
        super(message);
    }

    public static DifferentLineSizeException getInstance() {
        return DIFFERENT_LINE_SIZE_EXCEPTION;
    }
}
