package nextstep.ladder.domain.tobe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Point: 사다리 세로줄에서의 각 x 좌표 점 테스트")
class PointTest {

    @DisplayName("이동방향(Direction)에 대해 (-1,0,+1) 만큼 이동한다")
    @ParameterizedTest
    @MethodSource("source_move_shouldBeExpected")
    public void move_shouldBeExpected(Direction direction, int expected) {
        Point point = new Point(1);
        point.move(direction);
        assertThat(point.getIndex()).isEqualTo(expected);
    }

    public static Stream<Arguments> source_move_shouldBeExpected() {
        return Stream.of(
                Arguments.of(Direction.LEFT, 0),
                Arguments.of(Direction.CENTER, 1),
                Arguments.of(Direction.RIGHT, 2));
    }
}
