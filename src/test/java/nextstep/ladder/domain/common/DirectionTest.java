package nextstep.ladder.domain.common;

import nextstep.ladder.common.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Direction: 방향 값에 대한 테스트")
class DirectionTest {

    @DisplayName("각각의 이동방향은 -1,0,+1 값을 가진다")
    @ParameterizedTest
    @MethodSource("source_getValue_ReturnValue")
    public void getValue_ReturnValue(Direction direction, int expected) {
        assertThat(direction.getValue()).isEqualTo(expected);
    }

    public static Stream<Arguments> source_getValue_ReturnValue() {
        return Stream.of(
                Arguments.of(Direction.LEFT, -1),
                Arguments.of(Direction.CENTER, 0),
                Arguments.of(Direction.RIGHT, 1));
    }
}
