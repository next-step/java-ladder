package step4.ladderGame.domain.exception;

public class DifferentCountOfPlayerAndResultException extends IllegalArgumentException {

    private static final String DIFFERENT_COUNT_OF_PLAYER_AND_RESULT_ERROR_MESSAGE = "참가자와 결과의 갯수는 같아야합니다.";

    public DifferentCountOfPlayerAndResultException() {
        super(DIFFERENT_COUNT_OF_PLAYER_AND_RESULT_ERROR_MESSAGE);
    }

}
