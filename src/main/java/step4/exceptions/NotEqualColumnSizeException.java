package step4.exceptions;

public class NotEqualColumnSizeException extends IllegalArgumentException {

    private static final String COLUMN_SIZE = "시작 칼럼의 개수와, 결과 칼럼의 개수는 같아야 합니다.";

    public NotEqualColumnSizeException() {
        super(COLUMN_SIZE);
    }
}
