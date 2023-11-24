package nextstep.optional;

import java.util.Arrays;
import java.util.Optional;

enum Expression {
    PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

    private String expression;

    Expression(String expression) {
        this.expression = expression;
    }

    private static boolean matchExpression(Expression e, String expression) {
        return expression.equals(e.expression);
    }

    static Optional<Expression> of(String expression) {

        return Optional.ofNullable(
                        Arrays.stream(values())
                        .filter(ex -> matchExpression(ex, expression))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression))));
    }
}
