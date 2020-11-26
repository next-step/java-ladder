package exception;

public class NotMatchedCountException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "항목이 일대일 매칭되지 않습니다.";
    public NotMatchedCountException() {
        super(ERROR_MESSAGE);
    }
}
