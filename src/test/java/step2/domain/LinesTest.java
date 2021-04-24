package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.view.ResultView;

import java.util.List;

class LinesTest {

    private int size = 5;
    private int height = 5;


    @DisplayName("getLines로 호출시 불변인지 테스트")
    @Test
    void getLinesTest() {
        PointCondition pointCondition = new PointCondition();

        Lines lines = Lines.of(height, size, pointCondition);
        List<Line> expectedGetLines = lines.getLines();

        Assertions.assertThrows(UnsupportedOperationException.class, () -> expectedGetLines.remove(0));
    }

    @DisplayName("사다리 결과계산 테스트")
    @ParameterizedTest()
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2", "4:4"}, delimiter = ':')
    void calculateTest(int value, int expcetedPosition) {
        CustomCondition condition = new CustomCondition();

        Lines lines = Lines.of(height, size, condition);
        Position position = new Position(value);
        Position resultPosition = lines.getResultPosition(position);

        Assertions.assertEquals(resultPosition.getValue(), expcetedPosition);
    }
}