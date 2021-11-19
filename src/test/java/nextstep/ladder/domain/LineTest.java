package nextstep.ladder.domain;

import nextstep.ladder.doamin.Line;
import nextstep.ladder.doamin.value.Location;
import nextstep.ladder.doamin.value.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LineTest {
    @Test
    @DisplayName("라인 정상 생성 검증")
    void create() {
        assertDoesNotThrow(() -> Line.from(
                Arrays.asList(Point.from(false), Point.from(true), Point.from(false), Point.from(true))));
    }

    @Test
    @DisplayName("정보가 빈값이거나 null인 경우 예외 발생 검증")
    void create_exception() {
        assertAll(() -> {
            assertThatIllegalArgumentException().isThrownBy(() -> Line.from(Collections.emptyList()));
            assertThatIllegalArgumentException().isThrownBy(() -> Line.from(null));
        });
    }

    @Test
    @DisplayName("이전 지점과 현재 지점에 라인이 있는 경우 왼쪽이동 검증")
    void moveLeft() {
        Line line = Line.from(Arrays.asList(Point.from(false), Point.from(true)));
        Location location = Location.from(1);

        assertThat(line.getCurrentLocation(location)).isEqualTo(Location.from(0));
    }

    @Test
    @DisplayName("현재 지점과 다음 지점이 연결되어 있는 경우에만 오른쪽이동 검증")
    void moveRight() {
        Line line = Line.from(Arrays.asList(Point.from(false), Point.from(true)));
        Location location = Location.from(0);

        assertThat(line.getCurrentLocation(location)).isEqualTo(Location.from(1));
    }


    @Test
    @DisplayName("잘못된 값 입력시, 왼쪽 이동에 대한 예외 검증")
    void moveLeft_exception() {
        Line line = Line.from(Arrays.asList(Point.from(true), Point.from(true)));
        Location location = Location.from(1);

        assertThatIllegalArgumentException().isThrownBy(() -> line.getCurrentLocation(location));
    }


    @Test
    @DisplayName("잘못된 값 입력시, 오른쪽 이동에 대한 예외 검증")
    void moveRight_exception() {
        Line line = Line.from(Arrays.asList(Point.from(true), Point.from(true)));
        Location location = Location.from(0);

        assertThatIllegalArgumentException().isThrownBy(() -> line.getCurrentLocation(location));
    }


    @ParameterizedTest
    @MethodSource(value = "move")
    @DisplayName("사다리 한줄 라인에 대한 이동방향 검증")
    void move(List<Point> points, Integer currentLocation, Integer expected) {
        Line line = Line.from(points);

        Location result = line.getCurrentLocation(Location.from(currentLocation));
        assertThat(result).isEqualTo(Location.from(expected));
    }

    private static Stream<Arguments> move() {
        return Stream.of(
                Arguments.of(Arrays.asList(Point.from(false), Point.from(false), Point.from(false)), 0, 0),
                Arguments.of(Arrays.asList(Point.from(false), Point.from(false), Point.from(false)), 1, 1),
                Arguments.of(Arrays.asList(Point.from(false), Point.from(false), Point.from(false)), 2, 2),

                Arguments.of(Arrays.asList(Point.from(false), Point.from(true), Point.from(false)), 0, 1),
                Arguments.of(Arrays.asList(Point.from(false), Point.from(true), Point.from(false)), 1, 0),
                Arguments.of(Arrays.asList(Point.from(false), Point.from(true), Point.from(false)), 2, 2),

                Arguments.of(Arrays.asList(Point.from(false), Point.from(false), Point.from(true)), 0, 0),
                Arguments.of(Arrays.asList(Point.from(false), Point.from(false), Point.from(true)), 1, 2),
                Arguments.of(Arrays.asList(Point.from(false), Point.from(false), Point.from(true)), 2, 1)
        );
    }
}
