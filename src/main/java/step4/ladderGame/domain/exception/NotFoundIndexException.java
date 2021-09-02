package step4.ladderGame.domain.exception;

public class NotFoundIndexException extends IllegalArgumentException {

    private static final String NOT_FOUND_INDEX_ERROR_MESSAGE = "해당 인덱스 요소를 찾을 수 없습니다.";

    public NotFoundIndexException() {
        super(NOT_FOUND_INDEX_ERROR_MESSAGE);
    }

}
