package ladder.domain.direction;

import static ladder.domain.direction.Direction.DOWN;
import static ladder.domain.direction.Direction.LEFT;
import static ladder.domain.direction.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DirectionStrategyTest {

    private final DirectionStrategy strategy = new DirectionStrategy(() -> 1);

    @ParameterizedTest
    @MethodSource("provide")
    void 이전_방향에_따라서_다음_Direction_테스트(Direction previous, Direction result) {
        assertThat(strategy.getNextDirection(previous)).isEqualTo(result);
    }

    @Test
    void 첫_Point의_값_테스트() {
        assertThat(strategy.getDirectionToStart()).isEqualTo(RIGHT);
    }

    @ParameterizedTest
    @MethodSource("provide2")
    void 마지막_Point_값_테스트(Direction previous, Direction result) {
        assertThat(strategy.getDirectionToEnd(previous)).isEqualTo(result);
    }

    static Stream<Arguments> provide() {
        return Stream.of(
            Arguments.of(RIGHT, LEFT),
            Arguments.of(LEFT, RIGHT),
            Arguments.of(DOWN, RIGHT)
        );
    }

    static Stream<Arguments> provide2() {
        return Stream.of(
            Arguments.of(RIGHT, LEFT),
            Arguments.of(LEFT, DOWN),
            Arguments.of(DOWN, DOWN)
        );
    }
}