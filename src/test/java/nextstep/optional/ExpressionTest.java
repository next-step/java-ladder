package nextstep.optional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


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
                })
                .withMessage("&는 사칙연산에 해당하지 않는 표현식입니다.");
    }
}
