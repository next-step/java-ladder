package nextstep.optional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class ExpressionTest {
    @Test
    public void of() {
        assertThat(Expression.PLUS == Expression.of("+")).isTrue();
        assertThat(Expression.PLUS == Expression.ofWithStream("+")).isTrue();
    }

    @Test
    public void notValidExpression() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Expression.of("&");
                });
    }

    @Test
    public void notValidExpressionWithStream() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Expression.ofWithStream("&");
                });
    }
}
