package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


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

        int firstMovePosition = line.movePosition(0);
        int secondMovePosition = line.movePosition(1);
        int thirdMovePosition = line.movePosition(2);

        Assertions.assertAll(
                () -> assertEquals(firstMovePosition, 1),
                () -> assertEquals(secondMovePosition, -1),
                () -> assertEquals(thirdMovePosition, 0)
        );
    }
}