package step4.ladderGame.domain.exception;

public class CountOfResultOutOfBoundsException extends IllegalArgumentException {

    private static final String COUNT_OF_RESULT_OUT_OF_BOUNDS_ERROR_MESSAGE = "결과는 두가지 이상이어야 합니다.";

    public CountOfResultOutOfBoundsException() {
        super(COUNT_OF_RESULT_OUT_OF_BOUNDS_ERROR_MESSAGE);
    }

}
