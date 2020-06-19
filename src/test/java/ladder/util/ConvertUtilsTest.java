package ladder.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ConvertUtilsTest {
    @ParameterizedTest(name = "입력: {0}, 결과: {1}")
    @MethodSource("stringAndResult")
    @DisplayName("문자열을 쉽표로 구분할 수 있다.")
    void split_by_delimiter(String input, List<String> expected) {
        assertThat(ConvertUtils.split(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> stringAndResult() {
        return Stream.of(
                arguments("pobi,honux,crong,jk", Arrays.asList("pobi", "honux", "crong", "jk")),
                arguments("pobi", Arrays.asList("pobi")));
    }
}