package ladder.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @DisplayName("null 또는 공백을 입력하면 true가 리턴된다")
    @ParameterizedTest
    @NullAndEmptySource
    void isBlank(String input) {
        assertThat(StringUtils.isBlank(input)).isTrue();
    }
}
