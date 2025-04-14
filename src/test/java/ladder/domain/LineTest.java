package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    @DisplayName("전략이 항상 true일 때, point가 번갈아가면서 생성된다.")
    void drawTest_trueStrategy() {
        Line line = new Line(5, () -> true);
        List<Point> points = line.getPoints();

        assertThat(points).hasSize(4);
        for (int i = 1; i < points.size(); i++) {
            boolean prev = points.get(i - 1).hasPoint();
            boolean curr = points.get(i).hasPoint();
            assertThat(!(prev && curr)).isTrue();
        }
    }

    @Test
    @DisplayName("전략이 항상 false일 때, 모든 point는 생성되지 않는다.")
    void drawTest_falseStrategy() {
        Line line = new Line(5, () -> false);
        List<Point> points = line.getPoints();

        assertThat(points).hasSize(4);
        assertThat(points.stream().allMatch(Point::hasPoint)).isFalse();
    }

}
