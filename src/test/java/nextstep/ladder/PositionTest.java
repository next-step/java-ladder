package nextstep.ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositionTest {

    @Test
    void testPositionCreationWithNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> new Position(-1));
    }

    @Test
    void 제로에서_왼쪽으로_움직였을때_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Position(0).move(Direction.LEFT));
    }

    @ParameterizedTest
    @CsvSource({
            "RIGHT, 2",
            "LEFT, 0",
            "STRAIGHT, 1"
    })
    void moveTest(Direction direction, int expected) {
        String name = "test";
        Position position = new Position(1);
        position.move(direction);
        assertThat(position).isEqualTo(new Position(expected));
    }
}
