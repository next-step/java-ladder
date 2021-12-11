package nextstep.laddergame.model;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PointTest {

    @DisplayName("첫 Point는 index가 0이고, direction이 인자에 따라 달라지는지 검증")
    @Test
    void firstTest() {
        boolean right = true;
        assertThat(Point.first(right)).isEqualTo(new Point(0, new Direction(false, right)));
    }

    @DisplayName("마지막 Point는 index가 1증가하고, 마지막 direction을 가지는지 검증")
    @Test
    void lastTest() {
        Direction direction = Direction.first(true);
        Point point = new Point(0, direction);

        assertThat(point.last()).isEqualTo(new Point(1, direction.last()));
    }

    @DisplayName("다음 point는 index가 1증가하고, 인자로 받은 direction을 가지는지 검증")
    @Test
    void nextTest() {
        Direction direction = Direction.first(true);
        Point point = new Point(0, direction);

        assertThat(point.next(true)).isEqualTo(new Point(1, direction.next(true)));
    }

    @DisplayName("방향에 따라서 움직이는지 검증")
    @ParameterizedTest
    @MethodSource("points")
    void moveTest(Point point, int expected) {
        assertThat(point.move()).isEqualTo(expected);
    }

    private static Stream<Arguments> points() {
        return Stream.of(Arguments.of(new Point(1, new Direction(true, false)), 0),
                         Arguments.of(new Point(1, new Direction(false, true)), 2),
                         Arguments.of(new Point(1, new Direction(false, false)), 1));
    }
}
