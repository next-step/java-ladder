package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import nextstep.ladder.strategy.RandomDrawLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderRowTest {

    @ParameterizedTest
    @MethodSource("provideGameSettings")

    @DisplayName("1열이상의 길이를 가지는 한행의 사다리를 만들수 있다.")
    void createLadder(LadderDrawingSettings settings) {

        LadderStep ladderStep = new LadderStep(settings);
        assertThat(ladderStep.interSpacesSize()).isEqualTo(settings.getLadderWidth());
    }


    private static Stream<Arguments> provideGameSettings() {

        return Stream.of(
            Arguments.of(LadderDrawingSettings.of(LadderSize.of(2, 1), new RandomDrawLineStrategy())),
            Arguments.of(LadderDrawingSettings.of(LadderSize.of(2, 2), new RandomDrawLineStrategy())),
            Arguments.of(LadderDrawingSettings.of(LadderSize.of(10, 10), new RandomDrawLineStrategy()))
        );
    }
}