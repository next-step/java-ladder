package step4.ladderGame.domain.exception;

public class IndexLowException extends IllegalArgumentException {

    private static final String PLAYER_INDEX_LOW_ERROR_MESSAGE = "index는 0이상이어야 합니다.";

    public IndexLowException() {
        super(PLAYER_INDEX_LOW_ERROR_MESSAGE);
    }

}
