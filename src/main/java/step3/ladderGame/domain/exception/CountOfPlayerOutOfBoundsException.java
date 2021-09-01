package step3.ladderGame.domain.exception;

public class CountOfPlayerOutOfBoundsException extends IllegalArgumentException {

    private static final String COUNT_OF_PLAYER_OUT_OF_BOUNDS_ERROR_MESSAGE = "참가자는 두명 이상이어야 합니다.";

    public CountOfPlayerOutOfBoundsException() {
        super(COUNT_OF_PLAYER_OUT_OF_BOUNDS_ERROR_MESSAGE);
    }

}
