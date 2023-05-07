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
                });
    }

    @Test
    public void validExpression() {
        assertThat(Expression.of("+")).isEqualTo(Expression.PLUS);
        assertThat(Expression.of("-")).isEqualTo(Expression.MINUS);
        assertThat(Expression.of("/")).isEqualTo(Expression.DIVIDE);
        assertThat(Expression.of("*")).isEqualTo(Expression.TIMES);
    }
}
