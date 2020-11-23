package nextstep.ladder;

import nextstep.ladder.domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    @DisplayName("이름이 1글자 미만 5글자 초과면 throw Exception")
    void nameTestFailureCase(String invalidName) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Name.valueOf(invalidName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    @DisplayName("이름의 유효한 길이는 1글자 이상 5글자 이하다.")
    void nameTestSuccessCase(String validName) {
        assertThatCode(() -> Name.valueOf(validName))
                .doesNotThrowAnyException();
    }
}
