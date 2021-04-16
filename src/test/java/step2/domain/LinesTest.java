package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

class LinesTest {

    @DisplayName("getLines로 호출시 다른 객체로 생성되는지 테스트")
    @Test
    void getLinesTest() {
        int size = 5;
        int height = 5;

        PointsGeneration pointsGeneration = new PointsGeneration(size);
        PointCondition pointCondition = new PointCondition();
        List<Boolean> points = pointsGeneration.getPoints(pointCondition);

        List<Line> expectedLines = IntStream.range(0, height)
                .mapToObj(index -> new Line(points))
                .collect(toList());

        Lines lines = new Lines(expectedLines);
        List<Line> expectedGetLines = lines.getLines();
        expectedGetLines.remove(0);

        Assertions.assertNotEquals(expectedGetLines.size(), expectedLines.size());
    }
}