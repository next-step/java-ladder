package laddergame.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"    "})
    @DisplayName("isNonBlank(): stringInput이 NULL 또는 빈문자열인 경우 false를 그렇지 않은 경우 true를 반환한다.")
    void testIsNonBlank(String stringInput) {
        assertThat(Validator.isNonBlank(stringInput)).isEqualTo(false);
    }
}
