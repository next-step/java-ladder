package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LineTest {
    @Test
    @DisplayName("플레이어 수 - 1 만큼 point가 생성되었는지 확인한다.")
    void PointCreationTest() {
        int countOfPlayer = 5;
        Line line = new Line(countOfPlayer);

        Assertions.assertEquals(countOfPlayer - 1, line.getPoints().size());
    }

    @Test
    @DisplayName("연속된 두개의 point에 선이 없는지 확인한다.")
    void cannotDrawContinueLine() {
        int countOfPlayer = 5;
        Line line = new Line(countOfPlayer);

        List<Point> points = line.getPoints();
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i).hasPoint()) {
                Assertions.assertFalse(points.get(i + 1).hasPoint());
            }
        }
    }

}
