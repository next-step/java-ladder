package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @DisplayName("Position Move 테스트")
    @Test
    void positionMoveTest() {
        int expectedPosition = 1;
        Position position = new Position(10);
        assertEquals(position.move(expectedPosition), new Position(expectedPosition));
    }
}
