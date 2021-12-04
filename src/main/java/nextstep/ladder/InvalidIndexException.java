package nextstep.ladder;

public class InvalidIndexException extends ServiceException {

    private static final String MESSAGE = Point.MIN_INDEX + "이상의 값만 가능합니다.";

    public InvalidIndexException() {
        super(MESSAGE);
    }
}
