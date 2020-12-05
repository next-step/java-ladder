package ladder;


import ladder.ladderexceptions.InvalidLadderHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LadderTest {

    @Test
    @DisplayName("생성 테스트")
    void testGenerateLadder() {
        int numUser = 5;
        int numHeight = 0;
        assertThatExceptionOfType(InvalidLadderHeightException.class)
                .isThrownBy(() -> new Ladder(numHeight, numUser));
    }

    @Test
    @DisplayName("동일 테스트")
    void testLadderEquality() {
        assertThat(new Ladder(2, 2))
                .isEqualTo(new Ladder(Arrays.asList(HorizontalLine.ofLineCounts(2), HorizontalLine.ofLineCounts(2))));
    }

    private static Stream<Arguments> makePatterns() {
        return Stream.of(
                Arguments.of((HowToConnect) leftSideStatus -> false,
                        new Boolean[]{false, false, false, false}),
                Arguments.of((HowToConnect) leftSideStatus -> !leftSideStatus,
                        new Boolean[]{true, false, true, false}),
                Arguments.of((HowToConnect) leftSideStatus -> true,
                        new Boolean[]{true, true, true, true})
        );
    }

    @ParameterizedTest
    @MethodSource("makePatterns")
    @DisplayName("shuffle Test")
    void testShuffle(HowToConnect shuffleMode, Boolean[] expected) {
        int testHeight = 3;
        Ladder sampleLadder = new Ladder(testHeight, 4);
        Ladder expectedLadder = IntStream.range(0, testHeight)
                .mapToObj(x -> HorizontalLine.ofLines(Arrays.asList(expected)))
                .collect(collectingAndThen(toList(), Ladder::new));

        sampleLadder.shuffle(shuffleMode);

        assertThat(sampleLadder).isEqualTo(expectedLadder);
    }
}
