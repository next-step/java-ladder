package ladder.exception;

public class NullValueException extends IllegalArgumentException {
    private static final String NULL_VALUE_EXCEPTION_STATEMENT = "%s가 널값입니다.";

    public NullValueException(String value) {
        super(String.format(NULL_VALUE_EXCEPTION_STATEMENT, value));
    }
}
