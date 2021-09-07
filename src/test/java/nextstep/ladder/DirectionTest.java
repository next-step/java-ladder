package nextstep.ladder;

import nextstep.ladder.point.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {

    @Test
    @DisplayName("양쪽으로 이동 불가능하다")
    void invalid() {
        assertThrows(IllegalArgumentException.class, () -> Direction.of(true, true));
    }


    @ParameterizedTest
    @MethodSource("firstParam")
    void first(boolean movableRight, Direction expectedDirection) {
        Direction first = Direction.first(movableRight);
        assertEquals(expectedDirection, first);
    }

    @ParameterizedTest
    @MethodSource("lastParam")
    void last(boolean movableRight, Direction expectedDirection) {
        Direction first = Direction.first(movableRight);
        Direction last = first.last();
        assertEquals(expectedDirection, last);
    }

    @Test
    void next_left() {
        Direction direction = Direction.of(true, false);
        Direction left = direction.next(false);

        assertEquals(Direction.of(false, false), left);
    }

    @Test
    void next_right() {
        Direction direction = Direction.of(false, true);
        Direction right = direction.next(false);

        assertEquals(Direction.of(true, false), right);
    }

    @ParameterizedTest
    @MethodSource("moveParam")
    void move(Direction direction, int expectedMove) {
        int actualMove = direction.move();
        assertEquals(expectedMove, actualMove);
    }

    private static Stream<Arguments> moveParam() {
        return Stream.of(
                Arguments.of(getDownDirection(), 0),
                Arguments.of(getLeftDirection(), -1),
                Arguments.of(getRightDirection(), 1)
        );
    }

    private static Direction getDownDirection() {
        return Direction.of(false, false);
    }

    private static Direction getLeftDirection() {
        return Direction.of(true, false);
    }

    private static Direction getRightDirection() {
        return Direction.of(false, true);
    }

    private static Stream<Arguments> firstParam() {
        return Stream.of(
                Arguments.of(false, Direction.of(false, false)),
                Arguments.of(true, Direction.of(false, true))
        );
    }


    private static Stream<Arguments> lastParam() {
        return Stream.of(
                Arguments.of(false, Direction.of(false, false)),
                Arguments.of(true, Direction.of(true, false))
        );
    }
}
