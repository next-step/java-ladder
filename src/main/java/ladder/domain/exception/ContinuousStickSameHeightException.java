package ladder.domain.exception;

public class ContinuousStickSameHeightException extends RuntimeException {

    private static final ContinuousStickSameHeightException CONTINUOUS_STICK_SAME_HEIGHT_EXCEPTION =
            new ContinuousStickSameHeightException("같은 높이에 연속된 스틱이 존재합니다.");

    private ContinuousStickSameHeightException(String message) {
        super(message);
    }

    public static ContinuousStickSameHeightException getInstance() {
        return CONTINUOUS_STICK_SAME_HEIGHT_EXCEPTION;
    }
}
