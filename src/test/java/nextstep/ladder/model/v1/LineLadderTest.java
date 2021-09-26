package nextstep.ladder.model.v1;

import nextstep.ladder.model.api.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LineLadderTest {
    static Stream<Arguments> strategyResultProvider() {
        return Stream.of(
            Arguments.of(
                new AllDrawStrategy(), 1, 0
            ),
            Arguments.of(
                new OneByTwoDrawStrategy(true), 0, 1
            )
        );
    }

    @ParameterizedTest
    @DisplayName("build 하면 strategy 에 따라 사다리를 그린다")
    @MethodSource("strategyResultProvider")
    public void build(DrawStrategy strategy, int result0, int result1) {
        int WIDTH = 2;
        int HEIGHT = 5;
        LineLadderBuilder builder = new LineLadderBuilder(strategy);
        Ladder ladder = builder.build(WIDTH, HEIGHT);

        assertThat(ladder.height()).isEqualTo(HEIGHT);

        assertThat(ladder.climb(0)).isEqualTo(result0);
        assertThat(ladder.climb(1)).isEqualTo(result1);
    }
}