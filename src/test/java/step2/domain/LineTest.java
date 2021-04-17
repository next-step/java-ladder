package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LineTest {

    @DisplayName("사다리 포인트 테스트")
    @Test
    void lineCreatedTest() {
        CustomCondition customCondition = new CustomCondition();
        Line line = Line.of(2, customCondition);

        Assertions.assertEquals(line.getPoint(0), true);
        Assertions.assertEquals(line.getPoint(1), false);
    }
}