package nextstep.optional;

import java.util.Arrays;

enum Expression {
    PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

    private final String expression;

    Expression(String expression) {
        this.expression = expression;
    }

    private boolean matchExpression(String expression) {
        return expression.equals(this.expression);
    }

    static Expression of(String expression) {
        return Arrays.stream(values())
                .filter(it -> it.matchExpression(expression))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression)));
    }
}
