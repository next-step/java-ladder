package nextstep.ladder.domain;

import static nextstep.ladder.domain.Point.*;
import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

class PointTest {

    @DisplayName("라인의 각각의 좌표를 의미하는 Point 객체를 생성한다.")
    @EnumSource(value = Direction.class)
    @ParameterizedTest
    void create(Direction direction) {
        Point point = Point.of(0, direction);
        assertThat(point).isEqualTo(Point.of(0, direction));
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
