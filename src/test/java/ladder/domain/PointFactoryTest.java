package ladder.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointFactoryTest {
    @Test
    @DisplayName("가로 줄 links 가 주어졌을 때 각 인덱스에서 이동할 수 있는 방향을 나타내는 Point 리스트를 5개 생성한다")
    void createPointsFromLinks_WhenLinksSize4_GeneratesCorrectPoints() {
        List<Boolean> links = List.of(false, true, false, true);
        List<Point> points = PointFactory.createPointsFromLinks(links);

        assertThat(points).hasSize(5)
            .containsExactly(
                Point.STOP,
                Point.RIGHT,
                Point.LEFT,
                Point.RIGHT,
                Point.LEFT
            );
    }

    @Test
    @DisplayName("가로 줄 links 가 주어졌을 때 각 인덱스에서 이동할 수 있는 방향을 나타내는 Point 리스트를 6개 생성한다")
    void createPointsFromLinks_WhenLinksSize5_GeneratesCorrectPoints() {
        List<Boolean> links = List.of(false, true, false, true, false);
        List<Point> points = PointFactory.createPointsFromLinks(links);

        assertThat(points).hasSize(6)
            .containsExactly(
                Point.STOP,
                Point.RIGHT,
                Point.LEFT,
                Point.RIGHT,
                Point.LEFT,
                Point.STOP
            );
    }
}
