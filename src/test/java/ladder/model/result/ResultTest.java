package ladder.model.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ResultTest {

    @ParameterizedTest
    @ValueSource(strings = { "123456", "1234567", "12345678"})
    @DisplayName("실행 결과 길이가 5를 넘으면 예외 발생 테스트")
    void resultLengthOverFiveException(String value) {
        resultExceptionThrown(value, "실행 결과 길이는 5를 넘으면 안됩니다.");
    }

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("실행 결과가 null 이거나 비어있으면 예외 발생 테스트")
    void nullEmptyNameException(String value) {
        resultExceptionThrown(value, "실행 결과가 null 이거나 비어있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "1", "12", "123", "1234", "12345"})
    @DisplayName("실행 결과 길이가 5 이하면 정상적으로 생성 테스트")
    void resultObjectCreateTest(String value) {
        Result result = new Result(value);
        assertThat(result).isEqualTo(new Result(value));
    }

    private void resultExceptionThrown(String value, String s) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Result(value))
                .withMessage(s);
    }
}