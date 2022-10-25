package ladder.domain.exception;

public class NonNumericStringException extends RuntimeException {

    private static final NonNumericStringException NON_NUMERIC_STRING_EXCEPTION =
            new NonNumericStringException("숫자가 아닌 문자열이 입력되었습니다.");

    private NonNumericStringException(String message) {
        super(message);
    }

    public static NonNumericStringException getInstance() {
        return NON_NUMERIC_STRING_EXCEPTION;
    }
}
