package nextstep.optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class ExpressionTest {

  @Test
  void of() {
    assertThat(Expression.PLUS == Expression.of("+")).isTrue();
  }

  @Test
  void notValidExpression() {
    String expression = "&";
    assertThatIllegalArgumentException()
        .isThrownBy(() -> {
          Expression.of(expression);
        }).withMessage(expression + Expression.ILLEGAL_EXPRESSION);
  }
}
