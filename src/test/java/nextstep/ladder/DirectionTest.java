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
        assertThrows(IllegalArgumentException.class, () -> new Direction(true, true));
    }

    @Test
    void next_left() {
        Direction direction = new Direction(true, false);
        Direction left = direction.next(false);

        assertEquals(new Direction(false, false), left);
    }

    @Test
    void next_right() {
        Direction direction = new Direction(false, true);
        Direction right = direction.next(false);

        assertEquals(new Direction(true, false), right);
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
        return new Direction(false, false);
    }

    private static Direction getLeftDirection() {
        return new Direction(true, false);
    }

    private static Direction getRightDirection() {
        return new Direction(false, true);
    }
}
