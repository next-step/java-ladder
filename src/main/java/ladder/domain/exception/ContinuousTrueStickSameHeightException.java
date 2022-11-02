package ladder.domain.exception;

public class ContinuousTrueStickSameHeightException extends RuntimeException {

    private static final ContinuousTrueStickSameHeightException CONTINUOUS_TRUE_STICK_SAME_HEIGHT_EXCEPTION =
            new ContinuousTrueStickSameHeightException("같은 높이에 연속된 true 스틱이 존재합니다.");

    private ContinuousTrueStickSameHeightException(String message) {
        super(message);
    }

    public static ContinuousTrueStickSameHeightException getInstance() {
        return CONTINUOUS_TRUE_STICK_SAME_HEIGHT_EXCEPTION;
    }
}
