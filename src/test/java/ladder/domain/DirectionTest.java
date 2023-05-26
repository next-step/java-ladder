package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DirectionTest {

    public static Direction nonDirection = new Direction(false, false);
    public static Direction leftDirection = new Direction(true, false);
    public static Direction rightDirection = new Direction(false, true);

    @Test
    void Direction_left_right_true() {
        assertThatThrownBy(() -> new Direction(true, true))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("가로 라인은 겹칠 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("createNextArgs")
    void createNext(Direction direction, boolean addLine, Direction expected) {
        assertThat(direction.createNext(() -> addLine))
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("createLastArgs")
    void createLast(Direction direction, Direction expected) {
        assertThat(direction.createLast()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("moveArgs")
    void move(Direction direction, int expected) {
        assertThat(direction.move()).isEqualTo(expected);
    }

    static Stream<Arguments> createNextArgs() {
        return Stream.of(
            Arguments.of(nonDirection, true, rightDirection),
            Arguments.of(leftDirection, true, rightDirection),
            Arguments.of(rightDirection, true, leftDirection),
            Arguments.of(nonDirection, false, nonDirection),
            Arguments.of(leftDirection, false, nonDirection),
            Arguments.of(rightDirection, false, leftDirection)
        );
    }

    static Stream<Arguments> createLastArgs() {
        return Stream.of(
            Arguments.of(nonDirection, nonDirection),
            Arguments.of(leftDirection, nonDirection),
            Arguments.of(rightDirection, leftDirection)
        );
    }

    static Stream<Arguments> moveArgs() {
        return Stream.of(
            Arguments.of(nonDirection, 0),
            Arguments.of(leftDirection, -1),
            Arguments.of(rightDirection, 1)
        );
    }

}
