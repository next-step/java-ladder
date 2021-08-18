package nextstep.optional;

import java.util.Arrays;

enum Expression {
    PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

    private String expression;

    Expression(String expression) {
        this.expression = expression;
    }

    private static boolean matchExpression(Expression e, String expression) {
        return expression.equals(e.expression);
    }

//    static Expression of(String expression) {
//        for (Expression v : values()) {
//            if (matchExpression(v, expression)) {
//                return v;
//            }
//        }
//
//        throw new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression));
//    }

    /**
     * nextstep.optional.ExpressionTest 의 테스트가 통과하도록 Expression 의 of 메소드를 구현한다.
     * 단, of 메소드를 구현할 때 자바 8의 stream 을 기반으로 구현한다.
     */

    static Expression of(String expression) {
        return Arrays.stream(values())
                .filter(v -> matchExpression(v, expression))
                .findFirst()
                .orElseThrow(
                        () ->  new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression))
                );
    }

}
