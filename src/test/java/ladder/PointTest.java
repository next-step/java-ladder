package ladder;

import ladder.model.Point;
import ladder.model.PointRandomStrategy;
import ladder.teststrategy.PointFalseStrategy;
import ladder.teststrategy.PointTrueStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("가로 포인트가 null이거나 그려지지 않은 상태이고, random 값이 true 새로운 가로 포인트를 그린다.")
    void pointCreateTest() {
        Point newPoint = Point.create(new Point(false), new PointTrueStrategy());
        assertThat(newPoint.getStatus()).isTrue();
    }

    @Test
    @DisplayName("가로 포인트가 null이거나 그려지지 않은 상태이고, random 값이 false라면 새로운 가로 포인트를 그리지 않는다.")
    void pointNotCreateTest() {
        Point newPoint = Point.create(new Point(false), new PointFalseStrategy());
        assertThat(newPoint.getStatus()).isFalse();
    }

    @Test
    @DisplayName("기존 가로 포인트가 그려져 있다면 그려지지 않은 포인트가 생성된다.")
    void pointNotCreateStatusTrueTest() {
        Point newPoint = Point.create(new Point(true), new PointRandomStrategy());
        assertThat(newPoint.getStatus()).isFalse();
    }
}
