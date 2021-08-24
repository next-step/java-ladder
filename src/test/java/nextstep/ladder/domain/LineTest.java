package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import nextstep.ladder.exception.InvalidFirstPointException;
import nextstep.ladder.exception.InvalidLastPointException;
import nextstep.ladder.exception.InvalidMidPointException;

class LineTest {

    @DisplayName("하나의 라인을 생성한다.")
    @Test
    void create() {
        List<Point> points = Arrays.asList(right(0), left(1), down(2));
        Line line = new Line(points);
        assertThat(line).isEqualTo(new Line(points));
    }

    @DisplayName("첫 번째 지점이 왼쪽 방향이면 예외가 발생한다.")
    @Test
    void invalidFirstPoint() {
        List<Point> points = Arrays.asList(left(0), down(1), down(2));
        assertThatThrownBy(() -> new Line(points))
            .isInstanceOf(InvalidFirstPointException.class);
    }

    @DisplayName("마지막 지점이 오른쪽 방향이면 예외가 발생한다.")
    @Test
    void invalidLastPoint() {
        List<Point> points = Arrays.asList(right(0), left(1), right(2));
        assertThatThrownBy(() -> new Line(points))
            .isInstanceOf(InvalidLastPointException.class);
    }

    @DisplayName("가운데 지점이 유효한 연결이 아니라면 예외가 발생한다.")
    @MethodSource("invalidMidPointArguments")
    @ParameterizedTest
    void invalidMidPoint(List<Point> points) {
        assertThatThrownBy(() -> new Line(points))
            .isInstanceOf(InvalidMidPointException.class);
    }

    private static Stream<Arguments> invalidMidPointArguments() {
        return Stream.of(
            Arguments.of(Arrays.asList(down(0), right(1), down(2), down(3))),
            Arguments.of(Arrays.asList(down(0), right(1), right(2), down(3))),
            Arguments.of(Arrays.asList(right(0), left(1), left(2), down(3))),
            Arguments.of(Arrays.asList(down(0), down(1), left(2), down(3)))
        );
    }

    private static Point left(int position) {
        return new Point(position, Direction.LEFT);
    }

    private static Point right(int position) {
        return new Point(position, Direction.RIGHT);
    }

    private static Point down(int position) {
        return new Point(position, Direction.STRAIGHT);
    }

}
