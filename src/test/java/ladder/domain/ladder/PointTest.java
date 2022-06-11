package ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PointTest {

    @Test
    @DisplayName("첫 Point 의 방향 테스트")
    public void firstPointTest() {
        Assertions.assertThat(Point.first(false)).isEqualTo(new Point(0, new Direction(false, false)));
        Assertions.assertThat(Point.first(true)).isEqualTo(new Point(0, new Direction(false, true)));
    }

    @Test
    @DisplayName("다음 Point 의 방향 테스트")
    public void nextPointTest () {
        Point point = Point.first(true).next();
        Point result = new Point(1, new Direction(true, false));
        Assertions.assertThat(point).isEqualTo(result);
    }

    private static Stream<Arguments> lastPointArgs() {
        return Stream.of(
                arguments(new Point(3, new Direction(true, false)).last(), new Point(4, new Direction(false, false))),
                arguments(new Point(1, new Direction(false, false)).last(), new Point(2, new Direction(false, false))),
                arguments(new Point(5, new Direction(false, true)).last(), new Point(6, new Direction(true, false)))
        );
    }

    @ParameterizedTest
    @MethodSource("lastPointArgs")
    @DisplayName("마지막 Point 의 방향 테스트")
    public void lastPointTest (Point nowPoint, Point lastPoint) {
        Assertions.assertThat(nowPoint).isEqualTo(lastPoint);
    }

    @Test
    @DisplayName("현재 Point 의 오른쪽방향 테스트")
    public void rightPointTest() {
        Assertions.assertThat(new Point(0, new Direction(true, false)).isRight()).isEqualTo(false);
        Assertions.assertThat(new Point(2, new Direction(false, true)).isRight()).isEqualTo(true);
        Assertions.assertThat(new Point(100, new Direction(false, false)).isRight()).isEqualTo(false);
    }
}
