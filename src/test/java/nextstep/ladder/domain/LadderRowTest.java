package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import nextstep.ladder.strategy.DrawLineStrategy;
import nextstep.ladder.strategy.RandomDrawLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderRowTest {

    @ParameterizedTest
    @MethodSource("provideLadderStepParams")
    @DisplayName("1열이상의 길이를 가지는 한행의 사다리를 만들수 있다.")
    void createLadder(int playersCount, DrawLineStrategy strategy) {

        LadderStep ladderStep = new LadderStep(playersCount, strategy);
        assertThat(ladderStep.interSpacesSize()).isEqualTo(playersCount);
    }


    private static Stream<Arguments> provideLadderStepParams() {

        return Stream.of(
            Arguments.of(2, RandomDrawLineStrategy.getInstance()),
            Arguments.of(3, RandomDrawLineStrategy.getInstance()),
            Arguments.of(10, RandomDrawLineStrategy.getInstance())
        );
    }
}