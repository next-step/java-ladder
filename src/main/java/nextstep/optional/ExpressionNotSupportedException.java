package nextstep.optional;

public class ExpressionNotSupportedException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "%s는 사칙연산에 해당하지 않는 표현식입니다.";

    public ExpressionNotSupportedException(final String expression) {
        super(String.format(ERROR_MESSAGE, expression));
    }
}
