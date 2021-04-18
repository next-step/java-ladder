package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @DisplayName("이전 point 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:2", "3:2"}, delimiter = ':')
    void previousTest(int count, int expected) {
        CustomCondition customCondition = new CustomCondition();
        Line line = Line.of(3, customCondition);

        Position position = new Position(count);
        int previous = position.previous(line);

        assertEquals(previous, expected);
    }

    @DisplayName("다음 point 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:3", "3:4"}, delimiter = ':')
    void nextTest(int count, int expected) {
        CustomCondition customCondition = new CustomCondition();
        Line line = Line.of(3, customCondition);

        Position position = new Position(count);
        int next = position.next(line);

        assertEquals(next, expected);
    }

}