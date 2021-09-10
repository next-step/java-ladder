package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import nextstep.ladder.strategy.DrawLineStrategy;
import nextstep.ladder.strategy.RandomDrawLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderStepTest {

    @ParameterizedTest
    @MethodSource("provideGameSettings")
    @DisplayName("설정한 플레이어 수만큼의 사이공간이 생긴다.")
    void LadderStepSizeTest(int playersCount, DrawLineStrategy strategy) {
        LadderStep ladderStep = new LadderStep(playersCount, strategy);
        assertThat(ladderStep.interSpacesSize()).isEqualTo(playersCount);
    }


    private static Stream<Arguments> provideGameSettings() {

        return Stream.of(
            Arguments.of(2, RandomDrawLineStrategy.getInstance()),
            Arguments.of(5, RandomDrawLineStrategy.getInstance()),
            Arguments.of(10, RandomDrawLineStrategy.getInstance())
        );
    }

}