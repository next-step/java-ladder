package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.stream.Stream;
import nextstep.ladder.strategy.RandomDrawLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderTest {

    @ParameterizedTest
    @MethodSource("provideGameSettings")
    @DisplayName("2 x 1 이상의 사다리를 생성할수있다.")
    void createLadder(LadderDrawingSettings settings) {
        assertThatCode(() -> Ladder.from(settings, new RandomDrawLineStrategy()))
            .doesNotThrowAnyException();
    }

    private static Stream<Arguments> provideGameSettings() {

        return Stream.of(
            Arguments.of(LadderDrawingSettings.of(LadderSize.of(2, 1), ladderLabels, new RandomDrawLineStrategy())),
            Arguments.of(LadderDrawingSettings.of(LadderSize.of(2, 2), ladderLabels, new RandomDrawLineStrategy())),
            Arguments.of(LadderDrawingSettings.of(LadderSize.of(5, 5), ladderLabels, new RandomDrawLineStrategy())),
            Arguments.of(LadderDrawingSettings.of(LadderSize.of(10, 10), ladderLabels, new RandomDrawLineStrategy()))
        );
    }

}