package step4.domain.column;

public class ColumnSizeException extends IllegalArgumentException {
    private static final String COLUMN_SIZE = "시작 칼럼의 개수와, 결과 칼럼의 개수는 같아야 합니다.";

    public ColumnSizeException() {
        super(COLUMN_SIZE);
    }
}
