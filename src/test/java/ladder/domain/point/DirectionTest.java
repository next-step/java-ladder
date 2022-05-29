package ladder.domain.point;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DirectionTest {
    @ParameterizedTest
    @CsvSource(value = {"LEFT|0", "NONE|1", "RIGHT|2"}, delimiter = '|')
    void move는_position을_이동시킨다(Direction direction, int position) {
        assertEquals(position, direction.move(1));
    }

    @Test
    void next는_다음_direciton을_반환한다() {
        assertAll(
                () -> assertEquals(Direction.LEFT, Direction.RIGHT.next()),
                () -> assertNotEquals(Direction.LEFT, Direction.LEFT.next()),
                () -> assertNotEquals(Direction.LEFT, Direction.NONE.next())
        );
    }

    @Test
    void nextLast는_마지막_direciton을_반환한다() {
        assertAll(
                () -> assertEquals(Direction.LEFT, Direction.RIGHT.nextLast()),
                () -> assertEquals(Direction.NONE, Direction.LEFT.nextLast()),
                () -> assertEquals(Direction.NONE, Direction.NONE.nextLast())
        );
    }
}
