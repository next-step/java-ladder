package ladder.domain;

import ladder.ladderexceptions.InvalidLayoutException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HorizontalLineTest {

    private static Stream<Arguments> makePatterns() {
        return Stream.of(
                Arguments.of((HowToConnect) leftSideStatus -> false,
                        new Boolean[]{false, false, false, false, false}),
                Arguments.of((HowToConnect) leftSideStatus -> !leftSideStatus,
                        new Boolean[]{true, false, true, false, true}),
                Arguments.of(new SampleConcretePattern(),
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

    @Test
    @DisplayName("허용되지 않는 배열(연속 True)에 대한 예외처리 테스트")
    void testInvalidCondition() {
        Boolean[] input = {true, false, true, true};

        assertThatThrownBy(
                () -> HorizontalLine.ofLines(Arrays.asList(input))
        ).isInstanceOf(InvalidLayoutException.class);
    }

    static class SampleConcretePattern implements HowToConnect {
        private int idx = 0;

        public SampleConcretePattern() {
        }

        @Override
        public boolean needToConnect(Boolean leftSideCondition) {
            idx += 1;
            return isEven(idx);
        }

        private boolean isEven(int index) {
            return index % 2 == 0;
        }
    }
}
