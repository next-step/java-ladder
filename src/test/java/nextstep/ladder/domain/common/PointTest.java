package nextstep.ladder.domain.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("지점")
public class PointTest {

    public static Stream<Arguments> movePoint() {
        return Stream.of(
            Arguments.of(0, Direction.of(false, true), 1),
            Arguments.of(0, Direction.of(false, false), 0),
            Arguments.of(1, Direction.of(false, true), 2),
            Arguments.of(1, Direction.of(true, false), 0),
            Arguments.of(1, Direction.of(false, false), 1)
        );
    }

    @DisplayName("이동")
    @ParameterizedTest
    @MethodSource("movePoint")
    public void move(final int index, final Direction direction, final int expected) {
        assertThat(Point.of(index, direction).move()).isEqualTo(expected);
    }
}
