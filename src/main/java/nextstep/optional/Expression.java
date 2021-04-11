package nextstep.optional;

import java.util.Arrays;

enum Expression {
    PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

    public static final String IllegalArgument_Exception_Message = "%s는 사칙연산에 해당하지 않는 표현식입니다.";

    private final String expression;

    Expression(String expression) {
        this.expression = expression;
    }

    private static final boolean matchExpression(Expression e, String expression) {
        return expression.equals(e.expression);
    }

    static final Expression of(String expression) {
        return Arrays.stream(values())
                .filter(value -> matchExpression(value, expression))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(String.format(IllegalArgument_Exception_Message, expression))
                );
    }
}
