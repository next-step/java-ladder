package nextstep.ladder.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @DisplayName("공백 여부를 확인할 수 있다.")
    @ParameterizedTest
    @MethodSource("generateString")
    void canIsBlank(String value, boolean result) {
        assertThat(StringUtils.isBlank(value)).isEqualTo(result);
    }

    static Stream<Arguments> generateString() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of(" ", true),
                Arguments.of("abcd", false)
        );
    }

    @DisplayName("문자열을 숫자로 변환할 수 있다")
    @ParameterizedTest
    @CsvSource(value = { "1,1", "2,2", "3,3" })
    void canToInt(String value, int result) {
        assertThat(StringUtils.toInt(value)).isEqualTo(result);
    }
}
