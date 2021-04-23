package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LineTest {

    @DisplayName("사다리 포인트 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:true", "1:false", "2:false"}, delimiter = ':')
    void lineCreatedTest(int count, boolean actual) {
        CustomCondition customCondition = new CustomCondition();
        Line line = Line.of(2, customCondition);

        Assertions.assertEquals(line.isMoveable(count), actual);
    }
    
    @DisplayName("거리 계산 테스트")
    @Test
    void movePositionTest() {
        CustomCondition customCondition = new CustomCondition();
        Line line = Line.of(2, customCondition);

        Position firstMovePosition = line.movePosition(new Position(0));
        Position secondMovePosition = line.movePosition(new Position(1));
        Position thirdMovePosition = line.movePosition(new Position(2));

        Assertions.assertAll(
                () -> assertTrue(firstMovePosition.equals(new Position(1))),
                () -> assertTrue(secondMovePosition.equals(new Position(0))),
                () -> assertTrue(thirdMovePosition.equals(new Position(2)))
        );
    }
}