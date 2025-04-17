package ladder.domain;

import ladder.service.PointGenerator;
import ladder.service.StaticPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {
    @DisplayName("Line 생성 테스트")
    @Test
    void createLineTest() {
        int countOfPerson = 4;
        PointGenerator pointGenerator = new StaticPointGenerator(
                List.of(true, false, true)
        );
        Line line = new Line(countOfPerson, pointGenerator);

        List<Point> points = line.getPoints();

        assertEquals(countOfPerson - 1, points.size());
    }

    @DisplayName("Line 생성 시 두 개의 점이 연결될 수 없음")
    @Test
    void createLineWithConsecutiveConnectedPointsTest() {
        int countOfPerson = 4;
        PointGenerator pointGenerator = new StaticPointGenerator(
                List.of(true, true, false)
        );

        try {
            new Line(countOfPerson, pointGenerator);
        } catch (IllegalArgumentException e) {
            assertEquals("Two consecutive points cannot be connected.", e.getMessage());
        }
    }
}
