package nextstep.optional;

import java.util.List;

enum Expression {
    PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

    public final static List<Expression> VALUES = List.of(values());

    private String expression;

    Expression(String expression) {
        this.expression = expression;
    }

    private static boolean matchExpression(Expression e, String expression) {
        return expression.equals(e.expression);
    }

    static Expression of(String expression) {
        return VALUES.stream()
            .filter(v -> matchExpression(v, expression))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression)));
    }
}
