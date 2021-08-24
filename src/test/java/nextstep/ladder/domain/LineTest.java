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
        List<Point> points = Arrays.asList(right(), left(), down());
        Line line = new Line(points);
        assertThat(line).isEqualTo(new Line(points));
    }

    @DisplayName("첫 번째 지점이 왼쪽 방향이면 예외가 발생한다.")
    @Test
    void invalidFirstPoint() {
        List<Point> points = Arrays.asList(left(), down(), down());
        assertThatThrownBy(() -> new Line(points))
            .isInstanceOf(InvalidFirstPointException.class);
    }

    @DisplayName("마지막 지점이 오른쪽 방향이면 예외가 발생한다.")
    @Test
    void invalidLastPoint() {
        List<Point> points = Arrays.asList(right(), left(), right());
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
            Arguments.of(Arrays.asList(down(), right(), down(), down())),
            Arguments.of(Arrays.asList(down(), right(), right(), down())),
            Arguments.of(Arrays.asList(right(), left(), left(), down())),
            Arguments.of(Arrays.asList(down(), down(), left(), down()))
        );
    }

    private static Point left() {
        return new Point(Direction.LEFT);
    }

    private static Point right() {
        return new Point(Direction.RIGHT);
    }

    private static Point down() {
        return new Point(Direction.STRAIGHT);
    }

}
