package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HorizontalLineTest {

    private static Stream<Arguments> makePatterns() {
        return Stream.of(
                Arguments.of((HowToConnect) x -> false,
                        new Boolean[]{false, false, false, false, false}),
                Arguments.of((HowToConnect) x -> !x,
                        new Boolean[]{true, false, true, false, true}),
                Arguments.of((HowToConnect) x -> true,
                        new Boolean[]{true, true, true, true, true})
        );
    }

    @Test
    @DisplayName("초깃값 확인")
    void test() {
        Boolean[] booleans = {false, false, false, false};

        assertThat(HorizontalLine.of(4))
                .isEqualTo(HorizontalLine.of(Arrays.asList(booleans)));
    }

    @ParameterizedTest
    @MethodSource("makePatterns")
    @DisplayName("변경 테스트")
    void shuffle(HowToConnect strategy, Boolean[] expected) {
        HorizontalLine sampleLine = HorizontalLine.of(5);

        sampleLine.shuffle(strategy);

        assertThat(sampleLine)
                .isEqualTo(HorizontalLine.of(Arrays.asList(expected)));
    }
}
