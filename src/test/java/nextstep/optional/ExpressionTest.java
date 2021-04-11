package nextstep.optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class ExpressionTest {

    @DisplayName("of에 `+` 입력시 PLUS 열거형 반환하는지 테스트")
    @ParameterizedTest(name = "루프 : {index}, 연산자 : {1}")
    @MethodSource("provideExpression")
    public void of(Expression expression, String operator) {
        assertThat(expression == Expression.of(operator)).isTrue();
    }

    @DisplayName("사칙연산에 해당하지 않는 표현식 입력시 예외발생 여부 테스트")
    @Test
    public void notValidExpression() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Expression.of("&"))
                .withMessage("&는 사칙연산에 해당하지 않는 표현식입니다.");
    }

    private static Stream<Arguments> provideExpression() {
        return Stream.of(
                Arguments.of(Expression.PLUS, "+"),
                Arguments.of(Expression.MINUS, "-"),
                Arguments.of(Expression.TIMES, "*"),
                Arguments.of(Expression.DIVIDE, "/")
        );
    }
}
