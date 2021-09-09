package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import nextstep.ladder.strategy.RandomDrawLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderStepTest {

    @ParameterizedTest
    @MethodSource("provideGameSettings")
    @DisplayName("설정한 플레이어 수만큼의 사이공간이 생긴다.")
    void LadderStepSizeTest(LadderDrawingSettings settings, int expectedInterSpaceSize) {
        LadderStep ladderStep = new LadderStep(settings);
        assertThat(ladderStep.interSpacesSize()).isEqualTo(expectedInterSpaceSize);
    }


    private static Stream<Arguments> provideGameSettings() {

        return Stream.of(
            Arguments
                .of(LadderDrawingSettings.of(LadderSize.of(2, 1), ladderLabels, new RandomDrawLineStrategy()), 2),
            Arguments
                .of(LadderDrawingSettings.of(LadderSize.of(5, 5), ladderLabels, new RandomDrawLineStrategy()), 5),
            Arguments
                .of(LadderDrawingSettings.of(LadderSize.of(10, 10), ladderLabels, new RandomDrawLineStrategy()), 10)
        );
    }

}