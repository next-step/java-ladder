package step3.ladderGame.domain.exception;

public class NameLengthException extends IllegalArgumentException {

    private static final String IS_NOT_BETWEEN_ONE_AND_FIVE_ERROR_MESSAGE = "이름은 1~5글자 사이로 입력해야 합니다.";

    public NameLengthException() {
        super(IS_NOT_BETWEEN_ONE_AND_FIVE_ERROR_MESSAGE);
    }

}
