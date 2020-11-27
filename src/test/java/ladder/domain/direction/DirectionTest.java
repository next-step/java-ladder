package ladder.domain.direction;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import ladder.domain.Position;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DirectionTest {

    @ParameterizedTest
    @MethodSource("provide")
    void 방향에_따라_Position값_변화_테스트(Direction direction, Position expect) {
        Position startPosition = new Position(1);
        assertThat(direction.getNextPosition(startPosition)).isEqualTo(expect);
    }

    static Stream<Arguments> provide() {
        return Stream.of(
            Arguments.of(Direction.RIGHT, new Position(2)),
            Arguments.of(Direction.LEFT, new Position(0)),
            Arguments.of(Direction.DOWN, new Position(1))
        );
    }
}