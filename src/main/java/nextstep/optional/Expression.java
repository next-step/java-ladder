package nextstep.optional;

import java.util.Arrays;

enum Expression {
    PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

    private final String expression;

    Expression(String expression) {
        this.expression = expression;
    }

    private static boolean matchExpression(Expression e, String expression) {
        return expression.equals(e.expression);
    }

    static Expression ofOld(String expression) {
        for (Expression v : values()) {
            if (matchExpression(v, expression)) {
                return v;
            }
        }
        throw new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression));
    }

    static Expression of(String expression) {
        String statement = String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression);

        return Arrays.stream(Expression.values())
            .filter(e -> matchExpression(e, expression))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(statement));
    }
}
