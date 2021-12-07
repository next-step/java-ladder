package nextstep.ladder.exception;

public class LineRowException extends RuntimeException {
    private static final String MESSAGE = "line의 행 개수(%d)가 부족 합니다.";

    public LineRowException(int rowCount) {
        super(String.format(MESSAGE, rowCount));
    }
}
