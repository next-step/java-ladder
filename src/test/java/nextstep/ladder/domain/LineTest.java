package nextstep.ladder.domain;

import nextstep.ladder.doamin.Line;
import nextstep.ladder.doamin.Location;
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
        assertThatIllegalArgumentException().isThrownBy(() -> Line.from(Collections.emptyList()));
        assertThatIllegalArgumentException().isThrownBy(() -> Line.from(null));
    }

    @ParameterizedTest
    @MethodSource
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
