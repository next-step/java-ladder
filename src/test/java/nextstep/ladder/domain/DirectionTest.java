package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTest {

    @ParameterizedTest
    @MethodSource("provideIndexOfLane")
    @DisplayName("방향에 따라 Lane 변경")
    void changeLane(Direction direction, int startIndex, int endIndex) {
        Lane actual = direction.changeLane(startIndex);
        assertEquals(Lane.of(endIndex), actual);
    }

    private static Stream<Arguments> provideIndexOfLane() {
        return Stream.of(
                Arguments.of(Direction.LEFT, 1, 0),
                Arguments.of(Direction.LEFT, 2, 1),
                Arguments.of(Direction.RIGHT, 1, 2),
                Arguments.of(Direction.RIGHT, 2, 3),
                Arguments.of(Direction.STOP, 3, 3)
        );
    }
}
