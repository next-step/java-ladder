package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PointsTest {
    @Test
    @DisplayName("Point를 추가하고, 해당 인덱스에서 가져올 수 있다.")
    void addAndGetTest() {
        Points points = new Points();
        Point point = new Point(true);
        points.add(point);

        Point result = points.get(0);
        assertThat(result.hasPoint()).isTrue();
    }

    @Test
    @DisplayName("저장된 Point의 갯수를 반환한다.")
    void sizeTest() {
        Points points = new Points();
        points.add(new Point(true));
        points.add(new Point(false));
        points.add(new Point(true));

        assertThat(points.size()).isEqualTo(3);
    }

}
