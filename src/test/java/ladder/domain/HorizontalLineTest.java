package ladder.domain;

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
                Arguments.of((HowToConnect) leftSideStatus -> false,
                        new Boolean[]{false, false, false, false, false}),
                Arguments.of((HowToConnect) leftSideStatus -> !leftSideStatus,
                        new Boolean[]{true, false, true, false, true}),
                Arguments.of(new SampleShufflePattern(),
                        new Boolean[]{false, true, false, true, false})
        );
    }

    @Test
    @DisplayName("swap 조건 반환")
    void testSwapCondition() {
        Boolean[] input = {true, false, false, true};
        HorizontalLine line = HorizontalLine.ofLines(Arrays.asList(input));

        assertThat(line.needToSwap(0)).isEqualTo(true);
    }

    @Test
    @DisplayName("초깃값 확인")
    void test() {
        Boolean[] expected = {false, false, false, false};

        assertThat(HorizontalLine.ofLineCounts(4))
                .isEqualTo(HorizontalLine.ofLines(Arrays.asList(expected)));
    }

    @ParameterizedTest
    @MethodSource("makePatterns")
    @DisplayName("변경 테스트")
    void shuffle(HowToConnect strategy, Boolean[] expected) {
        HorizontalLine sampleLine = HorizontalLine.ofLineCounts(5);

        sampleLine.shuffle(strategy);

        assertThat(sampleLine)
                .isEqualTo(HorizontalLine.ofLines(Arrays.asList(expected)));
    }
}
