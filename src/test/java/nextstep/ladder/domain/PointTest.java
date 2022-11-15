package nextstep.ladder.domain;

import nextstep.ladder.codeleesh.domain.Direction;
import nextstep.ladder.codeleesh.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("위치 테스트")
class PointTest {

    @DisplayName("현재 위치를 구한다")
    @ParameterizedTest
    @MethodSource("provideMoveCurrentPoint")
    void current_point(final boolean left, final boolean right, final int expected) {

        final Point point = Point.first(left).next(right);
        assertThat(point.move()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideMoveCurrentPoint() {
        return Stream.of(
                Arguments.of(false, false, 1),
                Arguments.of(false, true, 2),
                Arguments.of(true, false, 0)
        );
    }

    @DisplayName("다음 위치를 구한다.")
    @Test
    void next_point() {

        final Point point = Point.first(false);
        final Point next = point.next(true);

        assertThat(next).isEqualTo(new Point(1, Direction.RIGHT));
    }

    @DisplayName("첫번째를 제외한 수만큼 포인트를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,true", "1,true", "2,true", "3,true", "4,false"})
    void last_index(final int index, final boolean expected) {

        final Point point = new Point(index, Direction.RIGHT);
        assertThat(point.untilExcludeStart(index, 5)).isEqualTo(expected);
    }

    @DisplayName("왼쪽 첫번째 사람은 왼쪽으로 이동할 수 없다.")
    @Test
    void left_first_move_right() {

        assertThat(Point.first(true).move()).isEqualTo(1);
    }

    @DisplayName("사다리를 이동한다.")
    @ParameterizedTest
    @MethodSource("provideMovePoint")
    void move(final boolean left, final boolean right, final int index) {

        final Point point = Point.first(left)
                .next(right);
        assertThat(point).isEqualTo(new Point(index, Direction.of(left, right)));
    }

    private static Stream<Arguments> provideMovePoint() {
        return Stream.of(
                Arguments.of(false, false, 1),
                Arguments.of(false, true, 1),
                Arguments.of(true, false, 1)
        );
    }
}