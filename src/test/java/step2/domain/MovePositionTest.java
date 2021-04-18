package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.exception.IllegalPositionException;

import static org.junit.jupiter.api.Assertions.*;

class MovePositionTest {

    private int size = 3;
    private Line line;

    @BeforeEach
    void init() {
        line = Line.of(size, new CustomCondition());
    }


    @DisplayName("BEGIN일 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:3", "3:4"}, delimiter = ':')
    void movePositionBeginTest(int count, int expectedPosition) {
        MovePosition movePosition = MovePosition.of(size, 0);

        int position = movePosition.getPosition(line, new Position(count));
        assertEquals(position, expectedPosition);
    }

    @DisplayName("Middle일 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:3", "3:4"}, delimiter = ':')
    void movePositionMiddleTest(int count, int expectedPosition) {
        MovePosition movePosition = MovePosition.of(size, 1);

        int position = movePosition.getPosition(line, new Position(count));
        assertEquals(position, expectedPosition);
    }

    @DisplayName("End일 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:2"}, delimiter = ':')
    void movePositionEndTest(int count, int expectedPosition) {
        MovePosition movePosition = MovePosition.of(size, size);

        int position = movePosition.getPosition(line, new Position(count));
        assertEquals(position, expectedPosition);
    }

    @DisplayName("현재 위치가 line의 길이보다 클경우 테스트")
    @Test
    void movePositionException() {
        assertThrows(IllegalPositionException.class, () -> MovePosition.of(size, size + 1));
    }

}