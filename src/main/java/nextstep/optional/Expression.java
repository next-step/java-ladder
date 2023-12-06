package nextstep.optional;

import java.util.stream.Stream;

enum Expression {
    PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

    private final String expression;

    Expression(String expression) {
        this.expression = expression;
    }

    static Expression of(String expression) {
        return Stream.of(Expression.values())
                     .filter(ex -> ex.getExpression().equals(expression))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression)));
    }

    public String getExpression() {
        return expression;
    }
}
