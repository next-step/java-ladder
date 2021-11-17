package nextstep.ladder.domain;

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

class LocationTest {

    @Test
    @DisplayName("현재 위치가 처음인 경우 왼쪽으로 갈 수 없다.")
    void isMoveLeft1() {
        Location location = Location.from(0);
        assertThat(location.isMoveLeft(Collections.singletonList(Point.from(true)))).isFalse();
    }

    @ParameterizedTest
    @MethodSource(value = "testPoints")
    @DisplayName("이전 지점과 현재 지점에 라인이 있는 경우만 왼쪽으로 갈 수 있다.")
    void isMoveLeft2(List<Point> points, boolean expected) {
        Location location = Location.from(1);
        assertThat(location.isMoveLeft(points)).isEqualTo(expected);
    }

    @Test
    @DisplayName("현재 위치가 마지막인 경우 오른쪽으로 갈 수 없다.")
    void isMoveRight1() {
        Location location = Location.from(1);
        assertThat(location.isMoveRight(Arrays.asList(Point.from(false), Point.from(true)))).isFalse();
    }

    @ParameterizedTest
    @MethodSource(value = "testPoints")
    @DisplayName("현재 지점과 다음 지점이 연결되어 있는 경우에만 오른쪽으로 갈 수 있다.")
    void isMoveRight2(List<Point> points, boolean expected) {
        Location location = Location.from(0);
        assertThat(location.isMoveRight(points)).isEqualTo(expected);
    }

    private static Stream<Arguments> testPoints() {
        return Stream.of(
                Arguments.of(Arrays.asList(Point.from(false), Point.from(true)), true),
                Arguments.of(Arrays.asList(Point.from(false), Point.from(false)), false));
    }
}
