package nextstep.ladder.domain.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("지점")
public class PointTest {

    public static Stream<Arguments> movePoint() {
        return Stream.of(
            Arguments.of(0, Direction.of(false, true), 1),
            Arguments.of(0, Direction.of(false, false), 0),
            Arguments.of(1, Direction.of(false, true), 2),
            Arguments.of(1, Direction.of(true, false), 0),
            Arguments.of(1, Direction.of(false, false), 1)
        );
    }

    @DisplayName("이동")
    @ParameterizedTest
    @MethodSource("movePoint")
    public void move(final int index, final Direction direction, final int expected) {
        assertThat(Point.of(index, direction).move()).isEqualTo(expected);
    }

    public static Stream<Arguments> isPossibleFirst() {
        return Stream.of(
            Arguments.of(Point.of(0, Direction.of(false, true)), true),
            Arguments.of(Point.of(0, Direction.of(false, false)), true),
            Arguments.of(Point.of(0, Direction.of(true, false)), false)
        );
    }

    @DisplayName("첫 번째 지점")
    @ParameterizedTest
    @MethodSource("isPossibleFirst")
    public void isPossibleFirst(final Point point, final boolean expected) {
        assertThat(point.isPossibleFirst()).isEqualTo(expected);
    }

    public static Stream<Arguments> isPossibleLast() {
        return Stream.of(
            Arguments.of(Point.of(10, Direction.of(false, true)), false),
            Arguments.of(Point.of(10, Direction.of(false, false)), true),
            Arguments.of(Point.of(10, Direction.of(true, false)), true)
        );
    }

    @DisplayName("마지막 지점")
    @ParameterizedTest
    @MethodSource("isPossibleLast")
    public void isPossibleLast(final Point point, final boolean expected) {
        assertThat(point.isPossibleLast()).isEqualTo(expected);
    }

    public static Stream<Arguments> isPossibleNext() {
        return Stream.of(
            // 정상
            Arguments.of(Point.of(1, Direction.of(false, true)),
                Point.of(2, Direction.of(true, false)), true),
            Arguments.of(Point.of(1, Direction.of(false, false)),
                Point.of(2, Direction.of(false, false)), true),

            // 연결될 수 없는 point
            Arguments.of(Point.of(1, Direction.of(false, false)),
                Point.of(2, Direction.of(true, false)), false),
            Arguments.of(Point.of(1, Direction.of(false, true)),
                Point.of(2, Direction.of(false, false)), false),

            // 연결될 수 있는 point 지만 index 가 맞지 않음
            Arguments.of(Point.of(1, Direction.of(false, true)),
                Point.of(3, Direction.of(true, false)), false),
            Arguments.of(Point.of(1, Direction.of(false, false)),
                Point.of(3, Direction.of(false, false)), false)
        );
    }

    @DisplayName("다음 지점")
    @ParameterizedTest
    @MethodSource("isPossibleNext")
    public void isPossibleNext(final Point current, final Point next, final boolean expected) {
        assertThat(current.isPossibleNext(next)).isEqualTo(expected);
    }
}
