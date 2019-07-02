package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @ParameterizedTest(name = "첫번째 포인트 방향 검증. generateValue={0}, expected={1}")
    @MethodSource
    void first(boolean generateValue, Direction expected) {

        Point point = Point.first(generateValue);
        assertThat(point.getDirection()).isSameAs(expected);
    }

    private static Stream<Arguments> first() {
        return Stream.of(
                Arguments.of(true, Direction.RIGHT),
                Arguments.of(false, Direction.EMPTY)
        );
    }

    @ParameterizedTest(name = "가운데 포인트 방향 검증. before={0}, generateValue={1}, expected={2}")
    @MethodSource
    void middle(Point before, boolean generateValue, Direction expected) {

        Point point = Point.middle(before, generateValue);
        assertThat(point.getDirection()).isSameAs(expected);
    }

    private static Stream<Arguments> middle() {
        return Stream.of(
                Arguments.of(Point.of(3, Direction.EMPTY), true, Direction.RIGHT),
                Arguments.of(Point.of(3, Direction.EMPTY), false, Direction.EMPTY),
                Arguments.of(Point.of(3, Direction.RIGHT), true, Direction.LEFT),
                Arguments.of(Point.of(3, Direction.RIGHT), false, Direction.LEFT),
                Arguments.of(Point.of(3, Direction.LEFT), true, Direction.EMPTY),
                Arguments.of(Point.of(3, Direction.LEFT), false, Direction.EMPTY)
        );
    }

    @ParameterizedTest(name = "마지막 포인트 방향 검증. before={0}, expected={1}")
    @MethodSource
    void last(Point before, Direction expected) {

        Point point = Point.last(before);
        assertThat(point.getDirection()).isSameAs(expected);
    }

    private static Stream<Arguments> last() {
        return Stream.of(
                Arguments.of(Point.of(5, Direction.EMPTY), Direction.EMPTY),
                Arguments.of(Point.of(5, Direction.RIGHT), Direction.LEFT)
        );
    }
}