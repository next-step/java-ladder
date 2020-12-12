package ladder.domain;


import ladder.ladderexceptions.InvalidLadderHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
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
                Arguments.of(new SampleShufflePattern(),
                        new Boolean[]{false, true, false, true})
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

    @Test
    @DisplayName("게임 동작 테스트")
    void testProcess() {
        HorizontalLine layer1 = HorizontalLine.ofLines(Arrays.asList(true, false, true));
        HorizontalLine layer2 = HorizontalLine.ofLines(Arrays.asList(false, false, true));
        HorizontalLine layer3 = HorizontalLine.ofLines(Arrays.asList(false, true, false));
        Ladder sampleLadder = new Ladder(Arrays.asList(layer1, layer2, layer3));

        Users inputs = new Users(Arrays.asList("a", "b", "c", "d"));
        Users expected = new Users(Arrays.asList("b", "c", "a", "d"));

        assertThat(sampleLadder.generateResult(inputs))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("게임 생성 테스트")
    void testGenerateLadderWithConnection() {
        int numUser = 5;
        int numHeight = 0;
        assertThatExceptionOfType(InvalidLadderHeightException.class)
                .isThrownBy(() -> new Ladder(numHeight, numUser, new SampleShufflePattern()));
    }

    @ParameterizedTest
    @CsvSource({"a,3등", "b,1등", "c,2등", "d,4등"})
    @DisplayName("게임 동작 테스트")
    void testGame(String input, String expected) {
        Line layer1 = Line.ofPoints(Arrays.asList(
                Point.custom1(0, PointStatus.custom(false, true)),
                Point.custom1(1, PointStatus.custom(true, false)),
                Point.custom1(2, PointStatus.custom(false, true)),
                Point.custom1(3, PointStatus.custom(true, false))
        ));
        Line layer2 = Line.ofPoints(Arrays.asList(
                Point.custom1(0, PointStatus.custom(false, false)),
                Point.custom1(1, PointStatus.custom(false, false)),
                Point.custom1(2, PointStatus.custom(false, true)),
                Point.custom1(3, PointStatus.custom(true, false))
        ));
        Line layer3 = Line.ofPoints(Arrays.asList(
                Point.custom1(0, PointStatus.custom(false, false)),
                Point.custom1(1, PointStatus.custom(false, true)),
                Point.custom1(2, PointStatus.custom(true, false)),
                Point.custom1(3, PointStatus.custom(false, false))
        ));

        Ladder sampleLadder = new Ladder(Arrays.asList(layer1, layer2, layer3));

        Users inputUsers = new Users(Arrays.asList("a", "b", "c", "d"));
        Rewards inputRewards = new Rewards(Arrays.asList("1등", "2등", "3등", "4등"));

        Result result = sampleLadder.generateResult(inputUsers, inputRewards);

        assertThat(result.responseForOne(input)).isEqualTo(expected);
    }
}
