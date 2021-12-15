package ladder.model.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = { "123456", "1234567", "12345678"})
    @DisplayName("이름 길이가 5를 넘으면 예외 발생 테스트")
    void nameLengthOverFiveException(String value) {
        nameExceptionThrown(value, "이름 길이는 5를 넘으면 안됩니다.");
    }

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("이름이 null 이거나 비어있으면 예외 발생 테스트")
    void nullEmptyNameException(String value) {
        nameExceptionThrown(value, "이름이 null 이거나 비어있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "1", "12", "123", "1234", "12345"})
    @DisplayName("이름 길이가 5 이하면 정상적으로 생성 테스트")
    void nameObjectCreateTest(String value) {
        Name name = new Name(value);
        assertThat(name).isEqualTo(new Name(value));
    }

    private void nameExceptionThrown(String value, String s) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(value))
                .withMessage(s);
    }
}
