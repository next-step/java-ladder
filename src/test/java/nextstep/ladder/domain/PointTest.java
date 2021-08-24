package nextstep.ladder.domain;

import static nextstep.ladder.domain.Direction.*;
import static nextstep.ladder.domain.Point.*;
import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import nextstep.ladder.exception.InvalidFirstPointException;

class PointTest {

    @DisplayName("라인의 각각의 좌표를 의미하는 Point 객체를 생성한다.")
    @EnumSource(value = Direction.class)
    @ParameterizedTest
    void create(Direction direction) {
        Point point = Point.of(1, direction);
        assertThat(point).isEqualTo(Point.of(1, direction));
    }

    @DisplayName("첫 번째 지점이 왼쪽 방향이면 예외가 발생한다.")
    @Test
    void invalidFirstPoint() {
        assertThatThrownBy(() -> Point.of(0, LEFT))
            .isInstanceOf(InvalidFirstPointException.class);
    }

    @DisplayName("사다리 지점을 연속적으로 생성한다.")
    @Test
    void create() {
        Point previousLeft = Point.of(1, LEFT);
        Point previousRight = Point.of(1, RIGHT);
        Point previousStraight = Point.of(1, STRAIGHT);
        assertThat(Point.next(previousLeft, true)).isEqualTo(Point.of(2, RIGHT));
        assertThat(Point.next(previousLeft, false)).isEqualTo(Point.of(2, STRAIGHT));
        assertThat(Point.next(previousRight, true)).isEqualTo(Point.of(2, LEFT));
        assertThat(Point.next(previousRight, false)).isEqualTo(Point.of(2, LEFT));
        assertThat(Point.next(previousStraight, true)).isEqualTo(Point.of(2, RIGHT));
        assertThat(Point.next(previousStraight, false)).isEqualTo(Point.of(2, STRAIGHT));
    }

    @DisplayName("각 지점의 방향으로 이동한다.")
    @MethodSource("moveArguments")
    @ParameterizedTest
    void move(Point point, int result) {
        assertThat(point.move()).isEqualTo(result);
    }

    private static Stream<Arguments> moveArguments() {
        return Stream.of(
            Arguments.of(right(1), 2),
            Arguments.of(left(1), 0),
            Arguments.of(straight(1), 1)
        );
    }

}
