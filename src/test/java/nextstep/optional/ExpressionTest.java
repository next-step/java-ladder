package nextstep.optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class ExpressionTest {

    @DisplayName(value = "Expression의 정의된 연산을 조회 테스트")
    @Test
    public void of() {
        assertThat(Expression.PLUS == Expression.of("+")).isTrue();
    }

    @DisplayName(value = "Expression의 정의된 연산이 아닌 경우 예외 테스트")
    @Test
    public void notValidExpression() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Expression.of("&");
                });
    }
}
