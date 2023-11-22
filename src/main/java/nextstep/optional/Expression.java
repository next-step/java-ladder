package nextstep.optional;

import java.util.Arrays;

enum Expression {
    PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

    private String expression;

    Expression(String expression) {
        this.expression = expression;
    }

    private boolean isMatchedWith(String symbol) {
        return expression.equals(symbol);
    }

    static Expression of(String symbol) {
        return Arrays.stream(values())
                .filter(expression -> expression.isMatchedWith(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", symbol)));
    }
}
