package nextstep.ladder.model.v2;


import nextstep.ladder.model.api.Ladder;
import nextstep.ladder.model.api.LadderBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LateralLadderTest {
    static Stream<Arguments> strategyResultProvider() {
        return Stream.of(
                Arguments.of(
                        new AllFalseLadderPointGenerator(), 0, 1
                ),
                Arguments.of(
                        new AllTrueLadderPointGenerator(), 1, 0
                )
        );
    }

    @ParameterizedTest
    @DisplayName("build 하면 strategy 에 따라 사다리를 그린다")
    @MethodSource("strategyResultProvider")
    public void build(LadderPointGenerator generator, int result0, int result1) {
        int WIDTH = 2;
        int HEIGHT = 5;
        LadderBuilder builder = new LateralLadderBuilder(generator);
        Ladder ladder = builder.build(WIDTH, HEIGHT);

        assertThat(ladder.height()).isEqualTo(HEIGHT);

        assertThat(ladder.climb(0)).isEqualTo(result0);
        assertThat(ladder.climb(1)).isEqualTo(result1);
    }
}