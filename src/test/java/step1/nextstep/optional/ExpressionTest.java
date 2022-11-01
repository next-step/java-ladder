package step1.nextstep.optional;

import org.junit.jupiter.api.Test;
import step1.nextstep.optional.Expression;

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
}
