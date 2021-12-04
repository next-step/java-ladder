package nextstep.ladder;

public class OutOfRangeIndexException extends ServiceException {

    private static final String MESSAGE = "범위 밖의 인덱스입니다.";

    public OutOfRangeIndexException() {
        super(MESSAGE);
    }
}
