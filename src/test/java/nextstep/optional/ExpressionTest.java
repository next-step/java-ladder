package nextstep.optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;


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
