package nextstep.ladder.domain;

import nextstep.ladder.exception.DirectionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class DirectionTest {

    @ParameterizedTest
    @DisplayName("Direction create test")
    @MethodSource
    void create(boolean left, boolean right, Direction expected) {
        Direction direction = Direction.of(left, right);

        assertThat(direction).isEqualTo(expected);
    }

    static Stream<Arguments> create() {
        return Stream.of(
                Arguments.of(
                    Boolean.FALSE, Boolean.TRUE, Direction.RIGHT
                ),
                Arguments.of(
                        Boolean.FALSE, Boolean.FALSE, Direction.STOP
                ),
                Arguments.of(
                        Boolean.TRUE, Boolean.FALSE, Direction.LEFT
                )
        );
    }

    @Test
    @DisplayName("Direction의 left & right 모두 true일 경우 exception")
    void exception() {
        assertThatThrownBy(() -> Direction.of(Boolean.TRUE, Boolean.TRUE)).isInstanceOf(DirectionException.class);
    }

    @ParameterizedTest
    @DisplayName("move test")
    @MethodSource
    void move(Direction direction, int startIndex, int expectedIndex) {
        assertThat(direction.move(startIndex)).isEqualTo(expectedIndex);
    }

    static Stream<Arguments> move() {
        return Stream.of(
                Arguments.of(
                    Direction.LEFT, 1, 0
                ),
                Arguments.of(
                    Direction.RIGHT, 1, 2
                ),
                Arguments.of(
                        Direction.STOP, 1, 1

                )
        );
    }
}