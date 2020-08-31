package nextstep.optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class ExpressionTest {

    @ParameterizedTest
    @CsvSource(value = {
            "+:PLUS",
            "-:MINUS",
            "*:TIMES",
            "/:DIVIDE",
    }, delimiter = ':')
    @DisplayName("연산 기호의 값이 제대로 반환 되는지 테스트")
    public void of(String symbol, Expression expected) {
        assertThat(Expression.of(symbol) == expected).isTrue();
    }

    @Test
    @DisplayName("없는 연산 기호인 경우 예외발생")
    public void notValidExpression() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Expression.of("&");
                }).withMessage("&는 사칙연산에 해당하지 않는 표현식입니다.");
    }
}
