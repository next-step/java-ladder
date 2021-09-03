package step4.ladderGame.domain.exception;

public class HaveSeveralDirectionsException extends IllegalArgumentException {

    private static final String HAVE_SEVERAL_DIRECTIONS_ERROR_MESSAGE = "오른쪽, 왼쪽길이 동시에 있을 수 는 없습니다.";

    public HaveSeveralDirectionsException() {
        super(HAVE_SEVERAL_DIRECTIONS_ERROR_MESSAGE);
    }

}
