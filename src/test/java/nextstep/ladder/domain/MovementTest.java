package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MovementTest {

    @DisplayName("왼쪽 첫번째 사람은 왼쪽으로 이동할 수 없다.")
    @Test
    void left_first_move_right() {

        final Movement movement = Movement.first(true);
        assertThat(movement.move()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("사다리 이동한다.")
    @ParameterizedTest
    @MethodSource("provideMovePoint")
    void move(final boolean left, final boolean right, final Direction direction) {

        final Movement movement = Movement.first(left)
                .next(right);
        assertThat(movement.move()).isEqualTo(direction);
    }

    private static Stream<Arguments> provideMovePoint() {
        return Stream.of(
                Arguments.of(false, false, Direction.DOWN),
                Arguments.of(false, true, Direction.RIGHT),
                Arguments.of(true, false, Direction.LEFT)
        );
    }
}
