package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LinesTest {

    @DisplayName("getLines로 호출시 불변인지 테스트")
    @Test
    void getLinesTest() {
        int size = 5;
        int height = 5;

        PointCondition pointCondition = new PointCondition();

        Lines lines = Lines.of(height, size, pointCondition);
        List<Line> expectedGetLines = lines.getLines();

        Assertions.assertThrows(UnsupportedOperationException.class, () -> expectedGetLines.remove(0));
    }
}