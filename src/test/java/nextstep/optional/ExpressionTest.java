package nextstep.optional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


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
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Expression.of(null);
                });
    }
}
