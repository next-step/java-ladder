package nextstep.ladder.domain;

import static nextstep.ladder.domain.Point.*;
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
        List<Point> points = Arrays.asList(right(0), left(1), straight(2));
        Line line = new Line(points);
        assertThat(line).isEqualTo(new Line(points));
    }

    @DisplayName("첫 번째 지점이 왼쪽 방향이면 예외가 발생한다.")
    @Test
    void invalidFirstPoint() {
        List<Point> points = Arrays.asList(left(0), straight(1), straight(2));
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

    @DisplayName("특정 시작 지점에서 이동 후 도착 위치를 얻는다.")
    @Test
    void move() {
        Line line = new Line(Arrays.asList(right(0), left(1), right(2), left(3)));
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isZero();
        assertThat(line.move(2)).isEqualTo(3);
        assertThat(line.move(3)).isEqualTo(2);
    }

    private static Stream<Arguments> invalidMidPointArguments() {
        return Stream.of(
            Arguments.of(Arrays.asList(straight(0), right(1), straight(2), straight(3))),
            Arguments.of(Arrays.asList(straight(0), right(1), right(2), straight(3))),
            Arguments.of(Arrays.asList(right(0), left(1), left(2), straight(3))),
            Arguments.of(Arrays.asList(straight(0), straight(1), left(2), straight(3)))
        );
    }

}
