package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class LineTest {

    @DisplayName("사다리 포인트 테스트")
    @Test
    void lineCreatedTest() {
        CustomCondition customCondition = new CustomCondition();
        List<Boolean> expectedPoints = IntStream.range(0, 2)
                .mapToObj(index -> customCondition.getCondition())
                .collect(Collectors.toList());

        Line line = new Line(expectedPoints);

        Assertions.assertEquals(line.getPoint(0), true);
        Assertions.assertEquals(line.getPoint(1), false);
    }
}