package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PointTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void createFirst(boolean addLine) {
        assertThat(Point.createFirst(() -> addLine)).isEqualTo(
            new Point(0, new Direction(false, addLine)));
    }

    @ParameterizedTest
    @MethodSource("createNextArgs")
    void createNext(int position, Direction direction, Point expected) {
        Point point = new Point(position, direction);
        assertThat(point.createNext(() -> true)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("createLastArgs")
    void createLast(int position, Direction direction, Point expected) {
        Point point = new Point(position, direction);
        assertThat(point.createLast()).isEqualTo(expected);
    }

    static Stream<Arguments> createNextArgs() {
        return Stream.of(
            Arguments.of(
                0, DirectionTest.nonDirection, new Point(1, DirectionTest.rightDirection)
            ),
            Arguments.of(
                1, DirectionTest.leftDirection, new Point(2, DirectionTest.rightDirection)
            ),
            Arguments.of(2, DirectionTest.rightDirection, new Point(3, DirectionTest.leftDirection))
        );
    }

    static Stream<Arguments> createLastArgs() {
        return Stream.of(
            Arguments.of(
                0, DirectionTest.nonDirection, new Point(1, DirectionTest.nonDirection)
            ),
            Arguments.of(
                1, DirectionTest.leftDirection, new Point(2, DirectionTest.nonDirection)
            ),
            Arguments.of(2, DirectionTest.rightDirection, new Point(3, DirectionTest.leftDirection))
        );
    }

}
