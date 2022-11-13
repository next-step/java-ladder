package nextstep.ladder.domain;

import nextstep.ladder.codeleesh.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("방향 테스트")
class DirectionTest {

    @DisplayName("연속된 사다리는 그릴 수 없다.")
    @Test
    void error_create() {

        assertThatThrownBy(() -> Direction.of(true, true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연속된 사다리는 그릴 수 없습니다.");
    }

    @DisplayName("현재 위치에서 사다리 이동 방향을 결정한다.")
    @ParameterizedTest
    @MethodSource("provideMovePoint")
    void create_direction(final boolean left, final boolean right, final Direction expected) {

        final Direction direction = Direction.of(left, right);
        assertThat(direction).isEqualTo(expected);
    }

    private static Stream<Arguments> provideMovePoint() {
        return Stream.of(
                Arguments.of(false, false, Direction.DOWN),
                Arguments.of(false, true, Direction.RIGHT),
                Arguments.of(true, false, Direction.LEFT)
        );
    }
}