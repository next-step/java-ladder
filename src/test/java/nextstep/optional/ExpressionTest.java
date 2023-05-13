package nextstep.optional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class ExpressionTest {
    @Test
    public void of() {
        assertThat(Expression.PLUS == Expression.of("+")).isTrue();
    }

    @Test
    public void notValidExpression() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Expression.of("&");
                }).withMessageContaining("는 사칙연산에 해당하지 않는 표현식입니다.");
    }
}
