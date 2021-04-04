package nextstep.optional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class ExpressionTest {
    @Test
    public void of() {
        assertThat(Expression.PLUS == Expression.of("+")).isTrue();
        assertThat(Expression.MINUS == Expression.of("-")).isTrue();
        assertThat(Expression.TIMES == Expression.of("*")).isTrue();
        assertThat(Expression.DIVIDE == Expression.of("/")).isTrue();
        assertThatThrownBy(() -> {
            Expression.of("B");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void notValidExpression() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Expression.of("&");
                });
    }
}
