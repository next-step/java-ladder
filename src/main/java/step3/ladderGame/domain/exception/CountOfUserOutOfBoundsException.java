package step3.ladderGame.domain.exception;

public class CountOfUserOutOfBoundsException extends IllegalArgumentException {

    private static final String COUNT_OF_USER_OUT_OF_BOUNDS_ERROR_MESSAGE = "참가자는 두명 이상이어야 합니다.";

    public CountOfUserOutOfBoundsException() {
        super(COUNT_OF_USER_OUT_OF_BOUNDS_ERROR_MESSAGE);
    }

}
