package nextstep.optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ExpressionTest {
    @DisplayName("연산기호에 맞는 값이 제대로 반환 되는지 확인")
    @CsvSource(value = {
            "+:PLUS",
            "-:MINUS",
            "*:TIMES",
            "/:DIVIDE",
    }, delimiter = ':')
    @ParameterizedTest
    public void of(String symbol, Expression expected) {
        // when & then
        assertThat(Expression.of(symbol) == expected).isTrue();
    }

    @DisplayName("지원하지 않는 연산기호 일 경우 예외")
    @Test
    public void notValidExpression() {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Expression.of("&"))
                .withMessage("&는 사칙연산에 해당하지 않는 표현식입니다.");
    }
}
