package ladder.domain.point;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {
    @ParameterizedTest
    @CsvSource(value = {"LEFT|0", "NONE|1", "RIGHT|2"}, delimiter = '|')
    void move는_position을_이동시킨다(Direction direction, int position) {
        assertEquals(position, direction.move(1));
    }
}
