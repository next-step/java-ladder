package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PointTest {

    @ParameterizedTest
    @DisplayName("move() 테스트")
    @MethodSource("moveSource")
    void move(Point point, int expected) {
        assertThat(point.move()).isEqualTo(expected);
    }

    static Stream<Arguments> moveSource() {
        return Stream.of(
                Arguments.of(new Point(1, Direction.of(true, false)), 0),
                Arguments.of(new Point(1, Direction.of(false, true)), 2),
                Arguments.of(new Point(1, Direction.of(false, false)), 1)
        );
    }
}