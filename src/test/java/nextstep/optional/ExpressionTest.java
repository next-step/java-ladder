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
    assertThatIllegalArgumentException()
        .isThrownBy(() -> {
          Expression.of("&");
        });
  }
}
