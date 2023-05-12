package nextstep.optional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class ExpressionTest {
    @Test
    void of() {
        assertThat(Expression.of("+")).isEqualTo(Expression.PLUS);
    }

    @Test
    void notValidExpression() {
        String invalidExpression = "&";
        assertThatThrownBy(() -> Expression.of(invalidExpression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(invalidExpression + "는 사칙연산에 해당하지 않는 표현식입니다.");
    }
}
