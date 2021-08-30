package step2.ladderGame.domain.exception;

public class NameNullOrEmptyException extends IllegalArgumentException {

    private static final String IS_NULL_OR_EMPTY_ERROR_MESSAGE = "입력값이 없습니다.";

    public NameNullOrEmptyException() {
        super(IS_NULL_OR_EMPTY_ERROR_MESSAGE);
    }

}
