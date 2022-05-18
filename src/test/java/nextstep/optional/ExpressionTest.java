package nextstep.optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("Optional 실습 - Expression 클래스 테스트")
public class ExpressionTest {
    @Test
    @DisplayName("문자와 매칭되는 Expression 얻어오는 테스트")
    void of() {
        assertThat(Expression.PLUS == Expression.of("+")).isTrue();
    }

    @Test
    @DisplayName("문자와 매칭되는 Expression이 없을 경우 예외가 발생한다.")
    void notValidExpression() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Expression.of("&");
                });
    }
}
