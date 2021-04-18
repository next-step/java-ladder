package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class LineTest {

    @DisplayName("사다리 포인트 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:true", "1:false", "2:false"}, delimiter = ':')
    void lineCreatedTest(int count, boolean actual) {
        CustomCondition customCondition = new CustomCondition();
        Line line = Line.of(2, customCondition);

        Assertions.assertEquals(line.getPoint(count), actual);
    }
}