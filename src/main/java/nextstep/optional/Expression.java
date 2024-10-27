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

    static Expression of(String expression) {
        if(expression ==null){
            throw new IllegalArgumentException("입력 값이 null입니다.");
        }
        return Arrays.stream(values())
                .filter(v -> matchExpression(v, expression))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression)));

    }
}
