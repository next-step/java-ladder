package nextstep.optional;

import java.util.Arrays;

enum Expression {
    PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

    private final String expressionMark;

    Expression(String expressionMark) {
        this.expressionMark = expressionMark;
    }

    static Expression of(String expressionMark) {
        return Arrays.stream(values())
                .filter(expression -> matchExpressionMark(expression, expressionMark))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expressionMark)));
    }

    private static boolean matchExpressionMark(Expression e, String expressionMark) {
        return expressionMark.equals(e.expressionMark);
    }
}
