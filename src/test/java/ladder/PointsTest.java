package ladder;

import ladder.domain.Point;
import ladder.domain.Points;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PointsTest {

    @DisplayName("Points 생성시 true인 Point 뒤엔 무조건 false Point가 생성되어야 한다.")
    @Test
    void points() {

        Point hasBridge = new Point (true);
        Points points = new Points(List.of(hasBridge), 5);
        Assertions.assertThat(points.getPoints().get(1).exist()).isFalse();
    }
}