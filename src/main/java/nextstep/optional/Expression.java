package nextstep.optional;

import java.util.Arrays;

enum Expression {
    PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

    private String expression;
    private static final String ERROR_MESSAGE = "%s는 사칙연산에 해당하지 않는 표현식입니다.";

    Expression(String expression) {
        this.expression = expression;
    }

    private static boolean matchExpression(Expression e, String expression) {
        return expression.equals(e.expression);
    }

    static Expression of(String expression) {
        return Arrays.stream(values())
                .filter(x -> matchExpression(x, expression))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(ERROR_MESSAGE, expression)));
    }
}
