package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @ParameterizedTest
    @MethodSource("provideMoveRightBridges")
    @DisplayName("첫번째 Bridge가 오른쪽으로 움직일 다리가 있는 경우")
    void moveRight(Point point) {
        assertThat(point.move()).isEqualTo(1);
    }

    private static Stream<Arguments> provideMoveRightBridges() {
        return Stream.of(
                Arguments.of(Point.firstPoint(() -> true))
        );
    }

    @ParameterizedTest
    @MethodSource("provideMoveLeftBridges")
    @DisplayName("두번째 Bridge가 왼쪽으로 움직일 다리가 있는 경우")
    void moveLeft(Point point) {
        assertThat(point.move()).isEqualTo(0);
    }

    private static Stream<Arguments> provideMoveLeftBridges() {
        return Stream.of(
                Arguments.of((Point.firstPoint(() -> true).next(() -> false)))
        );
    }

    @ParameterizedTest
    @MethodSource("provideNotMoveBridges")
    @DisplayName("두번째 Bridge가 양쪽으로 다리가 없는 경우")
    void moveNone(Point point) {
        assertThat(point.move()).isEqualTo(1);
    }

    private static Stream<Arguments> provideNotMoveBridges() {
        return Stream.of(
                Arguments.of((Point.firstPoint(() -> false).next(() -> false)))
        );
    }
}