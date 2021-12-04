package ladder.model.stringas;

import ladder.model.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringAsIntegerTest {

    @ParameterizedTest
    @ValueSource(strings = { "test1", "dkdkd", "notint"})
    @DisplayName("입력 값이 숫자가 아닐 떄 예외 발생 테스트")
    void notNumberExceptionTest(String value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringAsInteger(value))
                .withMessage("값이 숫자가 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "-1", "0", "5"})
    @DisplayName("입력받은 값으로 int 생성 테스트")
    void createHeightByInputTest(String value) {
        StringAsInteger stringAsInteger = new StringAsInteger(value);
        assertThat(stringAsInteger.get()).isEqualTo(Integer.parseInt(value));
    }
}