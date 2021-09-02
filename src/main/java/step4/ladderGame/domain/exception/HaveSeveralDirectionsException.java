package step4.ladderGame.domain.exception;

public class HaveSeveralDirectionsException extends IllegalArgumentException {

    private static final String HAVE_SEVERAL_DIRECTIONS_ERROR_MESSAGE = "길은 한 곳만 만들 수 있습니다.";

    public HaveSeveralDirectionsException() {
        super(HAVE_SEVERAL_DIRECTIONS_ERROR_MESSAGE);
    }

}
