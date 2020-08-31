package nextstep.optional;

import java.util.Arrays;
import java.util.function.Supplier;

enum Expression {
    PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

    private String expression;

    Expression(String expression) {
        this.expression = expression;
    }

    private static boolean matchExpression(Expression e, String expression) {
        return expression.equals(e.expression);
    }

    static Expression of(String expression) {
        return Arrays.stream(Expression.values())
                     .filter(value -> matchExpression(value, expression))
                     .findFirst()
                     .orElseThrow(throwIllegalArgumentException(expression));
    }

    private static Supplier<IllegalArgumentException> throwIllegalArgumentException(String expression) {
        return () -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression));
    }
}
