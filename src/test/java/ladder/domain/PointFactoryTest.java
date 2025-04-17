package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PointFactoryTest {
    @Test
    @DisplayName("플레이어 수만큼 point를 생성한다.")
    void createPointsWithCorrectSize() {
        int countOfPlayer = 5;
        List<Point> points = PointFactory.create(countOfPlayer, () -> true);

        assertThat(points).hasSize(countOfPlayer);
    }

    @Test
    @DisplayName("연속된 두개의 point가 true가 아니다.")
    void cannotDrawContinueLine() {
        int countOfPlayer = 5;
        List<Point> points = PointFactory.create(countOfPlayer, () -> true);

        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i).getCurrent()) {
                Assertions.assertFalse(points.get(i + 1).getCurrent());
            }
        }
    }

    @Test
    @DisplayName("전략이 항상 true일 때, point가 번갈아가면서 생성된다.")
    void drawTest_trueStrategy() {
        int countOfPlayer = 5;
        List<Point> points = PointFactory.create(countOfPlayer, () -> true);

        assertThat(points).hasSize(countOfPlayer);
        for (int i = 1; i < points.size(); i++) {
            boolean prev = points.get(i - 1).getCurrent();
            boolean curr = points.get(i).getCurrent();
            assertThat(!(prev && curr)).isTrue();
        }
    }

    @Test
    @DisplayName("전략이 항상 false일 때, 모든 point는 생성되지 않는다.")
    void drawTest_falseStrategy() {
        int countOfPlayer = 5;
        List<Point> points = PointFactory.create(countOfPlayer, () -> true);

        assertThat(points).hasSize(countOfPlayer);
        assertThat(points.stream().allMatch(Point::getCurrent)).isFalse();
    }

}
