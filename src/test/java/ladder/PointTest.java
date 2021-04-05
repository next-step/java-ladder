package ladder;

import ladder.domain.Point;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {

    @ParameterizedTest(name = "point_Next_RIGHT_Test")
    @MethodSource("point_Next_RIGHT_Provider")
    public void point_Next_RIGHT_Test(Point point, Point expected) {
        assertThat(Point.next(point)).isNotEqualTo(expected);
    }

    static Stream<Arguments> point_Next_RIGHT_Provider() {
        return Stream.of(
                Arguments.of(Point.RIGHT, Point.DOWN),
                Arguments.of(Point.RIGHT, Point.RIGHT)
        );
    }

    @ParameterizedTest(name = "point_Next_Test")
    @MethodSource("point_Next_Provider")
    public void point_Next_Test(Point point, Point expected) {
        assertThat(Point.next(point)).isNotEqualTo(expected);
    }

    static Stream<Arguments> point_Next_Provider() {
        return Stream.of(
                Arguments.of(Point.LEFT, Point.LEFT),
                Arguments.of(Point.DOWN, Point.LEFT)
        );
    }

}
