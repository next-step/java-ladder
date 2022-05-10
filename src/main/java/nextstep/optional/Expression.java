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


    /**
     *
     nextstep.optional.ExpressionTest의 테스트가 통과하도록 Expression의 of 메소드를 구현한다.
     단, of 메소드를 구현할 때 자바 8의 stream을 기반으로 구현한다.

     힌트
     Guide To Java 8 Optional 문서를 참고해 Optional 사용 방법을 익힌다.
     자바의 enum 전체 값은 values() 메소드를 통해 배열로 접근 가능하다.
     Arrays.stream()을 이용해 배열을 stream으로 생성할 수 있다.
     일치하는 값 하나를 추출할 때 findFirst() 메소드를 활용 가능하다.
     Optional의 orElseThrow() 메소드 활용해 구현한다.
     */
    static Expression of(String expression) {
        return Arrays.stream(values())
                .filter(v -> matchExpression(v, expression))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression)));
    }
}
