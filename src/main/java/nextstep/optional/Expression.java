package nextstep.optional;

import java.util.Arrays;

enum Expression {
  PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

  private String expression;
  private static final String INVALID_EXPRESSION = "%s는 사칙연산에 해당하지 않는 표현식입니다.";

  Expression(String expression) {
    this.expression = expression;
  }

  private static boolean matchExpression(Expression e, String expression) {
    return expression.equals(e.expression);
  }

  static Expression of(String expression) {

    return Arrays.stream(values())
        .filter(v -> matchExpression(v, expression))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException(
            String.format(INVALID_EXPRESSION, expression)
        ));
  }
}
