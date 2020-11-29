package step04.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step03.utils.Tokenizer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenizerTest {

    private static Stream<Arguments> provideStringWithCommaResult() {
        return Stream.of(
                Arguments.of("pobi,honux,crong,jk", Arrays.asList("pobi", "honux", "crong", "jk")),
                Arguments.of("꽝,5000,꽝,3000", Arrays.asList("꽝", "5000", "꽝", "3000"))
        );
    }

    @DisplayName(", 으로 토큰화")
    @ParameterizedTest
    @MethodSource("provideStringWithCommaResult")
    void test_tokenizeWithComma(String target, List<String> expect) {
        assertThat(Tokenizer.tokenizeWithComma(target))
                .isEqualTo(expect);
    }
}
